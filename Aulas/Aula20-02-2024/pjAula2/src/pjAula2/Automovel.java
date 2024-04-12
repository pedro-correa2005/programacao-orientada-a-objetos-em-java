package pjAula2;

import java.util.Date;

/**
 * Classe de Modelagem Conceitual de Automovel
 * @author Pedro
 * @data 29/02/2024
 */
public class Automovel {
	//Atributos
	private int renavam;
	private String modelo;
	private String cor;
	private int ano;
	private String fabricante;
	private float valor;
	private Date dataCompra;
	private boolean situacao;
	
	//M�todos
	
	public void inserir() {
		//TODO: implementar
	}
	
	public void excluir() {
		//TODO: implementar
	}
	
	//M�todo construtor
	/*public Automovel(int r, String m, String c, int a, String f, float v) {
		this.renavam = r;
		this.modelo = m;
		this.cor = c;
		this.ano = a;
		this.fabricante = f;
		this.valor = v;
	}*/
	
	//Getter e setters
	public void setRenavam(int r){
		this.renavam = r;
	}
	
	public int getRenavam() {
		return this.renavam;
	}
	
	public void setModeo(String m) {
		this.modelo = m;
	}
	
	public String getModelo() {
		return this.modelo;
	}
	
	public void setCor(String c) {
		this.cor = c;
	}
	
	public String getCor() {
		return this.cor;
	}
	
	public void setAno(int a) {
		this.ano = a;
	}
	
	public int getAno() {
		return this.ano;
	}
	
	public void setFabricante(String f) {
		this.fabricante = f;
	}
	
	public String getFabricante() {
		return this.fabricante;
	}
	
	public void setValor(float v) {
		this.valor = v;
	}
	
	public float getValor() {
		return this.valor;
	}
	
	public void setDataCompra(Date d) {
		this.dataCompra = d;
	}
	
	public Date getDataComra() {
		return this.dataCompra;
	}
	
	public void setSituacao(boolean s) {
		this.situacao = s;
	}
	
	public boolean getSituacao() {
		return this.situacao;
	}
}