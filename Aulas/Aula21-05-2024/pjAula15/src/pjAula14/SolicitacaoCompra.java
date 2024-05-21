package pjAula14;

public class SolicitacaoCompra {

	public static void main(String[] args) {
		PedidoCompra pc = new PedidoCompra();
		
		pc.setId(100);
		pc.setOrigem(OrigemPedidoCompra.INTEGRACAO);

		System.out.println(pc.getOrigem());
		System.out.println(pc.getOrigem().getDescricao());
		System.out.println(pc.getOrigem().getValor());
	}

}
