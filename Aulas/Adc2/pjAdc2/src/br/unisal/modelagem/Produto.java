package br.unisal.modelagem;

/**
 * Classe de Modelagem Conceitual de Produto
 * @author Pedro H. L. Corrêa
 * @date 16/04/2024
 */

public class Produto {
	//Atributos
	private int codigo;
	private String descricao;
	private UnidadeMedida un;
	private float largura;
	private float comprimento;
	private Situacao situacao;
	private String localizacao;
	
	//Métodos
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public UnidadeMedida getUn() {
		return un;
	}
	public void setUn(UnidadeMedida un) {
		this.un = un;
	}
	
	public float getLargura() {
		return largura;
	}
	public void setLargura(float largura) {
		this.largura = largura;
	}
	
	public float getComprimento() {
		return comprimento;
	}
	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}
	
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	@Override
	public String toString() {
		return "Código: " + this.getCodigo()
		+ " Descrição: " + this.getDescricao()
		+ " UnidadeMedida: " + this.getUn().getDescricao()
		+ " Largura: " + this.getLargura()
		+ " Comprimento: " + this.getComprimento()
		+ " Situação: " + this.getSituacao()
		+ " Localização: " + this.getLocalizacao();
	}
}
