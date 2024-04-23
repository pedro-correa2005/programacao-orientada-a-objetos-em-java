package pjAula11;

import java.io.File;

public class PrimeiroTexto {
	public static void main(String[] args) {
		String informacoes = "";
		File arquivo = new File("MeuPrimeiroArquivo.txt");
		
		System.out.println(arquivo.getAbsolutePath());
	}
}
