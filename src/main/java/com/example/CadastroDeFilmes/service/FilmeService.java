package com.example.CadastroDeFilmes.service;

import com.example.CadastroDeFilmes.entity.Filme;
import com.example.CadastroDeFilmes.repository.FilmeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public Filme salvar(Filme filme) {
        if (filme.getNome() == null || filme.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do filme é obrigatório");
        }

        if (filme.getDiretor() == null || filme.getDiretor().isBlank()) {
            throw new IllegalArgumentException("O diretor do filme é obrigatório");
        }

        if (filme.getAnoLancamento() == null) {
            throw new IllegalArgumentException("O ano de lançamento do filme é obrigatório");
        }

        if (filme.getAnoLancamento() < 1888 || filme.getAnoLancamento() > 2030) {
            throw new IllegalArgumentException("O ano do lançamento deve estar entre 1888 e 2030");
        }

        Filme filmeSalvo = filmeRepository.save(filme);

        log.info("Filme salvo com sucesso");

        return filmeSalvo;
    }

    public List<Filme> listarTodos() {
        return filmeRepository.findAll();
    }

    public Filme buscarPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O id é obrigatório");
        }

        return filmeRepository.findById(id).orElseThrow();
    }

    public Filme atualizar(Long id, Filme dadosAtualizado) {
        Filme filmeExistente = buscarPorId(id);

        filmeExistente.setNome(dadosAtualizado.getNome());
        filmeExistente.setDiretor(dadosAtualizado.getDiretor());
        filmeExistente.setAnoLancamento(dadosAtualizado.getAnoLancamento());
        filmeExistente.setSinopse(dadosAtualizado.getSinopse());

        return salvar(filmeExistente);
    }

    public void deletar(Long id) {
        buscarPorId(id);

        try {
            filmeRepository.deleteById(id);
        }
        catch (Exception e) {
            throw new RuntimeException("Erro ao deletar o filme");
        }

        log.info("Filme deletado com sucesso");
    }
}
