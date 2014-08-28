package com.estoque.teste;

import java.util.List;

import com.estoque.dao.LoteDAO;
import com.estoque.dao.ProdutoDAO;
import com.estoque.entidade.Lote;
import com.estoque.entidade.Produto;

public class Teste {
	public static void main(String[] args) {
		Produto produto = new Produto();
		Lote lote = new Lote();

		LoteDAO loteDAO = new LoteDAO();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		produtoDAO.salvar(produto);
		
		
		
		
		
		
		

	}
}
