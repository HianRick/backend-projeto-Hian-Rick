package com.example.Api_BackEnd.Controller;

import com.example.Api_BackEnd.Entities.Jogos;
import com.example.Api_BackEnd.Services.JogosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class JogosController {
    @Autowired
    private JogosService jogosService;


    @GetMapping("/jogos")
    public List<Jogos> getJogos() {
        return jogosService.getJogos();
    }


    @GetMapping("/jogos/developer/{nome}")
    public List<Jogos> getJogosPorDeveloper(@PathVariable String nome) {
        return jogosService.getJogosPorDeveloper(nome);
    }
    @GetMapping("/jogos/ano/{ano}")
    public List<Jogos> getJogosPorAno(@PathVariable int ano) {
        return jogosService.getJogosPorAno(ano);
    }


    @PostMapping("/jogos")
    public Jogos criarJogo(@RequestBody Jogos novoJogo) {
        return jogosService.adicionarJogo(novoJogo);
    }
    @PostMapping("/jogos/recomendar")
    public List<Jogos> recomendarJogosPorPalavrasChave(@RequestBody List<String> palavrasChave) {
        return jogosService.recomendarJogosPalavrasChave(palavrasChave);
    }
    @GetMapping("/sobre")
    public Map<String, Object> getSobre() {
        return Map.of(
                "integrantes", List.of("Hian Rick Francesconi Macedo"),
                "nome_projeto", "SindromedoPcGamer.api"
        );
    }

}