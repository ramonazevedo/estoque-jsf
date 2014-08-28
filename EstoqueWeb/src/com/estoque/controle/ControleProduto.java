package com.estoque.controle;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.estoque.dao.ProdutoDAO;
import com.estoque.entidade.Produto;

@ManagedBean
@SessionScoped
public class ControleProduto {

	Produto produto;
	List<Produto> produtos;
	ProdutoDAO produtoDAO;

	public ControleProduto() {
		produtoDAO = new ProdutoDAO();
		produto = new Produto();
	}

	public String salvar() {
		produto.setDataCadastrada(new Date());
		produtoDAO.salvar(produto);
		return "index";

	}

	public String remover() {
		produtoDAO.remover(produto);
		return "index";

	}

	public String editar() {
		return "cadastroProduto";
	}

	public String novo() {
		produto = new Produto();
		return "cadastroProduto";
	}

	public Produto selecionarProduto() {
		
		produto = produtoDAO.selecionarProduto(produto.getId());
		return produto;

	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		produtos = produtoDAO.listarTodosProdutos();
		return produtos;

	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
