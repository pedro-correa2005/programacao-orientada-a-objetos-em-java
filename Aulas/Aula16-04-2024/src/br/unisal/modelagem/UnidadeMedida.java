package br.unisal.modelagem;

public enum UnidadeMedida {
	UN("UN", "Unidade"),
	PC("PC", "Peça"),
	MT("MT", "Metro"),
	TON("TON", "Tonelada"),
	CX("CX", "Caixa"),
	DZ("DZ","Dúzia"),
	LT("LT", "Litro"),
	RL("RL", "Rolo");
	
	private String unidade;
	private String descrição;
	
	
	private UnidadeMedida(String unidade, String descrição) {
		this.unidade = unidade;
		this.descrição = descrição;
	}
}
