package com.example.testingweb.buiders;

import com.example.testingweb.produto.Produto;
import com.example.testingweb.produto.ValorInvalido;

public class ProdutoBuilder {

    private String descricao;
    private double valorUnitario;

    public ProdutoBuilder comValorUnitario(double valorUnitarioEsperada) {
        this.valorUnitario = valorUnitarioEsperada;
        return this;
    }

    public Produto construir() throws ValorInvalido { 
        Produto produto = new Produto(descricao, valorUnitario);
        return produto;
    }

    public ProdutoBuilder comDescricao(String descricaoEsperado) { 
        this.descricao = descricaoEsperado;
        return this;
    }
    

}
