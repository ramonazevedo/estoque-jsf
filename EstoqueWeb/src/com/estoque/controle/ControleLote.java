package com.estoque.controle;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.estoque.dao.LoteDAO;
import com.estoque.entidade.Lote;
import com.estoque.entidade.Produto;

@ManagedBean
@SessionScoped
public class ControleLote {
	
	Lote lote;
	List<Lote> lotes;
	LoteDAO loteDAO;
	
	public ControleLote() {
		 lote = new Lote();
		 loteDAO =  new LoteDAO();
	}
	
	public String salvar(){
		lote.setDataCadastrada(new Date());
		loteDAO.salvar(lote);
		return "listarLotes";
	}
	
	public String deletar(){
		loteDAO.deletar(lote);
		return "listarLotes";
	}
	
	public String novo(){
		lote = new Lote();
		return "cadastroLotes";
	}
	
	public String editar(){
		return "listarLotes";
	}
	
	
	
	
	
	
	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public List<Lote> getLotes() {
		lotes = loteDAO.listarTodosLotes();
		return lotes;
	}

	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}

	public LoteDAO getLoteDAO() {
		return loteDAO;
	}

	public void setLoteDAO(LoteDAO loteDAO) {
		this.loteDAO = loteDAO;
	}
}
