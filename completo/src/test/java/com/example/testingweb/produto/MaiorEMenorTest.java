package com.example.testingweb.produto;

import com.example.testingweb.buiders.CarrinhoDeCompraBuilder;
import com.example.testingweb.carrinho.CarrinhoDeCompra;
import com.example.testingweb.carrinho.ItemDoCarrinho;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestComponent;

public class MaiorEMenorTest {
    private static final int UM = 1;
    private Produto geladeira;
    private Produto liquidificador;
    private Produto pratos;

    @BeforeEach
	public void inicializar() throws Exception {
		geladeira = new Produto("Geladeira", 450.0);
        liquidificador = new Produto("Liquidificador", 250.0);
        pratos = new Produto("Jogo de pratos", 70.0);
	}
    
    @Test
    public void deve_verificar_o_menor_em_ordem_decrescente() throws CarrinhoVazioException {
        CarrinhoDeCompra carrinho = carrinhoDecrescente();
        
        MaiorEMenor algoritmo = new MaiorEMenor();
        algoritmo.encontra(carrinho);
        
        Assertions.assertEquals(pratos, algoritmo.getMenor());
    }

    private CarrinhoDeCompra carrinhoDecrescente() {
        CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
        carrinho.adicionar(new ItemDoCarrinho(geladeira, UM));
        carrinho.adicionar(new ItemDoCarrinho(liquidificador, UM));
        carrinho.adicionar(new ItemDoCarrinho(pratos, UM));
        return carrinho;
    }  

    @Test 
    public void deve_verificar_o_maior_em_ordem_decrescente()throws ValorInvalido, CarrinhoVazioException{ 
        CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompraBuilder()
        .comItemDoCarrinho(new ItemDoCarrinho(this.geladeira, UM))
        .comItemDoCarrinho(new ItemDoCarrinho(this.liquidificador, UM))
        .comItemDoCarrinho(new ItemDoCarrinho(this.pratos, UM))
        .construir();
        MaiorEMenor algoritmo = new MaiorEMenor();
        algoritmo.encontra(carrinhoDeCompra);

        Assertions.assertEquals(pratos, algoritmo.getMenor());

    } 


    // outras ordens
    // apenas um produto
    // carrinho sem produto 

   

    @Test
    public void deve_verificar_o_maior_preco_unitario_em_ordem_crescente() throws ValorInvalido{
       CarrinhoDeCompra carrinho = new CarrinhoDeCompraBuilder().construir();
    } 


    @Test
    public void deve_lancar_excecao_para_carrinho_sem_produto() throws ValorInvalido{
        CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompraBuilder().construir();

        MaiorEMenor MaiorEMenor = new MaiorEMenor();

        Assertions.assertThrows(CarrinhoVazioException.class, ()->{ 
            MaiorEMenor.encontra(carrinhoDeCompra);

        });
    }
}