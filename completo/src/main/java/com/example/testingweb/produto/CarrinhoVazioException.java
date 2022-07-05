package com.example.testingweb.produto;

public class CarrinhoVazioException extends Exception { 
    @Override
    public String getMessage(){
        return "o carrinho não pode ser vazio";
    }
    
}
