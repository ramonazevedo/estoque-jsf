package com.estoque.controle;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.estoque.dao.LoteDAO;
import com.estoque.dao.ProdutoDAO;
import com.estoque.entidade.Lote;
import com.estoque.entidade.Produto;

@ManagedBean
@SessionScoped
public class ControleLote {
	
	private Lote lote;
	private List<Lote> lotes;
	private LoteDAO loteDAO;
	private int produtoSelected;
	
	public ControleLote() {
		 lote = new Lote();
		 loteDAO =  new LoteDAO();
	}
	
	public String salvar(){
		ProdutoDAO pd = new ProdutoDAO();
		lote.setDataCadastrada(new Date());
		Produto p = pd.selecionarProduto(produtoSelected);
		lote.setProduto(p);
		loteDAO.salvar(lote);
		return "listarLotes";
	}
	
	public String deletar(){
		loteDAO.deletar(lote);
		return "listarLotes";
	}
	
	public String novo(){
		lote = new Lote();
		return "listarLotes";
	}
	
	public String editar(){
		return "cadastroLotes";
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

	public int getProdutoSelected() {
		return produtoSelected;
	}

	public void setProdutoSelected(int produtoSelected) {
		this.produtoSelected = produtoSelected;
	}
}
