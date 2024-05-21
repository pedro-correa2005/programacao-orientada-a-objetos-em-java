package pjAula14;

public enum OrigemPedidoCompra {
	SISTEMA("Sistema", 0),
	IMPORTACAO_ARQUIVO("Importação de Arquivo", 1),
	INTEGRACAO("Integração", 2);
	
	private int valor;
	private String descricao;

	private OrigemPedidoCompra(String descricao, int valor) {
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
