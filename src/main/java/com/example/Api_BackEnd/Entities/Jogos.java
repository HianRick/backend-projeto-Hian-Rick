package com.example.Api_BackEnd.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Jogos {
    @JsonProperty("id")
    private int codigo;

    @JsonProperty("title")
    private String nome;

    @JsonProperty("short_description")
    private String descricao;

    @JsonProperty("developer")
    private String developer;

    @JsonProperty("release_date")
    private String dataLancamento;

    public Jogos() {}

    public int getCodigo() {return codigo;}

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
