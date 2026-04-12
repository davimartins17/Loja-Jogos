package org.example.jogo.service;

import org.example.jogo.model.Jogo;
import org.example.jogo.repository.jogoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class jogoService {

    private final jogoRepository repository;

    public jogoService(jogoRepository repository){
        this.repository = repository;
    }
    public Jogo salvar(Jogo jogo){
        return repository.save(jogo);
    }

    public Jogo atualizar(Jogo jogo, Long codigoAtivacao){
        Jogo existente = repository.findById(codigoAtivacao).orElseThrow(() -> new RuntimeException("Jogo não encontrado"));
        existente.setNome(jogo.getNome());
        existente.setPreco(jogo.getPreco());
        existente.setCategoria(jogo.getCategoria());
        return repository.save(existente);
    }
    public List<Jogo> buscar(){
        return repository.findAll();
    }
    public Jogo buscarNome(String nome){
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public void deletar(Long codigoAtivacao){
        repository.deleteById(codigoAtivacao);
    }


}
