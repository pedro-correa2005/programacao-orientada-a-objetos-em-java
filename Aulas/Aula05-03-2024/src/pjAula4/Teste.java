package pjAula4;

public class Teste {
	public static void main(String [] args) {
		Calculadora calc = new Calculadora();
		long v1 = 45, v2 = 65;
		System.out.println(calc.soma(v1, v2));
		
		int a = 123, b = 987;
		System.out.println(calc.soma(a, b));
		
		System.out.println(calc.soma("7", "78"));
		
		System.out.println(calc.soma(8, 4, 16));
		
		System.out.println(calc.soma(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		
		System.out.println(calc.soma("11", "12", "13", "14", "15"));
	}
}