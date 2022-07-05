package com.example.testingweb.produto;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.testingweb.buiders.ProdutoBuilder;

public class ProdutoTest {

	private static final double VALOR_NEGATIVO = -1d;

	@Test
	public void nao_deve_permitir_informar_valor_menor_que_zero() throws Exception {
		assertThrows(ValorInvalido.class, ()-> {
			new Produto("Fogão 4 bocas", VALOR_NEGATIVO);
		});
	} 
	@Test
	public void deve_conter_um_valor_unitario_positivo() throws ValorInvalido{ 
		//Arrange
		double valorUnitarioEsperada = 10.0;
		//Act
		
		Produto produto = new ProdutoBuilder()
		.comValorUnitario(valorUnitarioEsperada)
		.construir();
		//Asserti
		
		Assertions.assertEquals(valorUnitarioEsperada, produto.getValorUnitario());
	} 
	@Test
	public void deve_conter_uma_descricao() throws ValorInvalido{ 
		//Arrange
		String descricaoEsperado = "Fogão de 4 bocas";
		//Act
		
		Produto produto = new ProdutoBuilder()
		.comDescricao(descricaoEsperado)
		.construir();
		//Asserti
		
		Assertions.assertEquals(descricaoEsperado, produto.getDescricao());
	} 
}
	
