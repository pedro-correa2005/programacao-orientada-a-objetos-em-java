package pjAula9;

import javax.swing.JOptionPane;

public class TesteAplicacao {
	public static int[] vet = new int[1000000];
	public static void preencher(int numero) {
		try {
			for(int i = 0; i < numero + 1; i++) {
				vet[i] = i;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Falha ao realizar a ação");
		}
		
		try{
			int valorA = Integer.parseInt(JOptionPane.showInputDialog("Informe um número"));
			int valorB = Integer.parseInt(JOptionPane.showInputDialog("Inforeme outro número"));
			JOptionPane.showMessageDialog(null, valorA / valorB);
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Valor informado não é um número inteiro");
		}catch(ArithmeticException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar dividir por zero");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Inicio");
		preencher(1_000_000);
		System.out.println("Fim");
	}
}