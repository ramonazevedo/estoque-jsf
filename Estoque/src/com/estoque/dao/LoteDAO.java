package com.estoque.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.estoque.entidade.Lote;

public class LoteDAO {
	EntityManagerFactory emf;
	EntityManager em;
	
	public LoteDAO() {
		emf = Persistence.createEntityManagerFactory("ramon");
		em = emf.createEntityManager();
	}
	
	public Lote selecionarLote(int id){
		em.getTransaction().begin();
		Lote lote =  em.find(Lote.class, id);
		em.getTransaction().commit();
		emf.close();
		return lote;
	}
	
	public void salvar(Lote lote){
		em.getTransaction().begin();
		em.merge(lote);
		em.getTransaction().commit();
		emf.close();
		
	}
	
	public void deletar(Lote lote){
		em.getTransaction().begin();
		em.remove(lote);
		em.getTransaction().commit();
		emf.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Lote> listarTodosLotes(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select lote from Lote lote"); 
		List<Lote> lotes = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return lotes;
		
	}

}
