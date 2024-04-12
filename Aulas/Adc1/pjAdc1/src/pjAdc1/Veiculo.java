package pjAdc1;

import java.util.Date;
/**
 * Questão 1
 * @autor Pedro Henrique Lima Corrêa
 */
public class Veiculo {
	// Atributos
	private String placa;
	private String fabricante;
	private String modelo;
	private int anoFabricacao;
	private float valor;
	private Date dataCompra;

	// Método Construtor

	public Veiculo(String placa, String fabricante, String modelo, int anoFabricacao, float valor, Date dataCompra) {
		super();
		this.placa = placa;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.valor = valor;
		this.dataCompra = dataCompra;
	}

	// Getters e Setters
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	
}
