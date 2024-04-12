package pjAula4;

public class TesteOperacao {
	public void calcular(OperacaoMatematica op, double a, double b) {
		System.out.println(op.calcular(a,b));
		op.getTipo();
	}
	
	public static void main(String [] args) {
		TesteOperacao teste = new TesteOperacao();
		
		teste.calcular(new Soma(), 123, 456);
		teste.calcular(new Subtracao(), 123, 456);
		
		OperacaoMatematica mat = new Multiplicacao();
		teste.calcular(mat, 3, 6);
	}
}