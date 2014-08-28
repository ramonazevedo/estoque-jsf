package com.estoque.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.estoque.entidade.Produto;

public class ProdutoDAO {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public ProdutoDAO() {
		emf = Persistence.createEntityManagerFactory("ramon");
		em = emf.createEntityManager();
	}
	
	public Produto selecionarProduto(int id){
		em.getTransaction().begin();
		Produto produto =  em.find(Produto.class, id);
		em.getTransaction().commit();
		emf.close();
		return produto;
	}
	
	public void salvar(Produto produto) {
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remover(Produto produto) {
		em.getTransaction().begin();
		em.remove(produto);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listarTodosProdutos(){
		em.getTransaction().begin();
		Query consultar =  em.createQuery("select produto from Produto produto");
		List<Produto> produtos = consultar.getResultList();
		em.getTransaction().commit();
		emf.close();
		return produtos;
		
	}
	


}
