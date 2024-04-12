package pjAula2;
import java.util.Scanner;

public class Teste {
	public static void main(String[] args) {
		
		Cliente[] agenda = new Cliente[5];

		for(int i=0; i < 5; i++) {
			String n;
			String e;
			float t;
			
			Scanner digito = new Scanner(System.in);
			Cliente elemento = new Cliente();
			
			System.out.print("Insira o nome: ");
			n = digito.nextLine();
			elemento.setNome(n);
			
			System.out.print("Insira o email: ");
			e = digito.nextLine();
			elemento.setEmail(e);
			
			System.out.print("Insira o telefone: ");
			t = digito.nextFloat();
			elemento.setTelefone(t);
		
			agenda[i] = elemento;
			
			digito.close();
		}
		
		for(int i=0; i < 5; i++) {
			System.out.println(agenda[i].info());
		}
	}
}