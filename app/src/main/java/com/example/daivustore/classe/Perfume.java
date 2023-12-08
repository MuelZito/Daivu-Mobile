package com.example.daivustore.classe;

import android.graphics.drawable.Drawable;

public class Perfume {
    int imgPerfume;
    String nome;
    String descricao;
    String preco;

    public Perfume(int imgPerfume, String nome, String descricao, String preco) {
        this.imgPerfume = imgPerfume;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getImgPerfume() {
        return imgPerfume;
    }

    public void setImgPerfume(int imgPerfume) {
        this.imgPerfume = imgPerfume;
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

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
