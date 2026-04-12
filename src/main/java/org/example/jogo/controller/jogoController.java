package org.example.jogo.controller;

import jakarta.validation.Valid;
import org.example.jogo.model.Jogo;
import org.example.jogo.service.jogoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Jogo")
@RestController
public class jogoController {

    private final jogoService service;

    public jogoController(jogoService service){
        this.service = service;
    }

    @GetMapping
    public List<Jogo> listar(){
        return service.buscar();
    }

    @GetMapping("/{nome}")
    public Jogo buscarPorNome(@PathVariable  String nome){
        return service.buscarNome(nome);
    }

    @PostMapping
    public Jogo salvar(@RequestBody @Valid Jogo jogo){
        return service.salvar(jogo);
    }

    @PutMapping("/{codigoAtivacao}")
    public Jogo atualizar(@RequestBody @Valid Jogo jogo,@PathVariable Long codigoAtivacao){
        return service.atualizar(jogo,codigoAtivacao);
    }
    @DeleteMapping("/Jogo/{codigoAtivacao}")
    public void deletar(@PathVariable Long codigoAtivacao){
        service.deletar(codigoAtivacao);
    }


}
