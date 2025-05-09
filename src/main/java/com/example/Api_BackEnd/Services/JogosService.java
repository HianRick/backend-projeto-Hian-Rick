package com.example.Api_BackEnd.Services;

import com.example.Api_BackEnd.Entities.Jogos;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JogosService {
    private RestTemplate cliente = new RestTemplate();
    private List<Jogos> jogosCriados = new ArrayList<>();

    public List<Jogos> getJogos() {
        Jogos[] jogos = cliente.getForObject("https://www.freetogame.com/api/games", Jogos[].class);
        List<Jogos> todos = new ArrayList<>();
        if (jogos != null) todos.addAll(Arrays.asList(jogos));
        todos.addAll(jogosCriados);
        return todos;
    }

    public List<Jogos> getJogosPorDeveloper(String nome) {
        String nomeLower = nome.toLowerCase();
        return getJogos().stream()
                .filter(jogo -> jogo.getDeveloper() != null &&
                        jogo.getDeveloper().toLowerCase().contains(nomeLower))
                .toList();
    }
    public List<Jogos> getJogosPorAno(int ano) {
        return getJogos().stream()
                .filter(jogo -> {
                    String data = jogo.getDataLancamento();
                    if (data != null && data.length() >= 4) {
                        try {
                            int anoDoJogo = Integer.parseInt(data.substring(0, 4));
                            return anoDoJogo == ano;
                        } catch (NumberFormatException e) {
                            return false;
                        }
                    }
                    return false;
                })
                .toList();
    }

    public Jogos adicionarJogo(Jogos jogo) {
        jogosCriados.add(jogo);
        return jogo;
    }

    public List<Jogos> recomendarJogosPalavrasChave(List<String> palavrasChave) {
        return getJogos().stream()
                .filter(jogo -> {
                    String descricao = jogo.getDescricao() != null ? jogo.getDescricao().toLowerCase() : "";
                    int matchCount = 0;


                    for (String palavra : palavrasChave) {
                        if (descricao.contains(palavra.toLowerCase())) {
                            matchCount++;
                        }
                    }


                    return matchCount > 0;
                })
                .collect(Collectors.toList());
    }
}
