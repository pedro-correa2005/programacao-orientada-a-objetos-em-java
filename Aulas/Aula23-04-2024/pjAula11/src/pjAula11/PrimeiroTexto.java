package pjAula11;

import java.io.File;
import java.io.IOException;

public class PrimeiroTexto {
	public static void main(String[] args) {
		String informacoes = "";
		File arquivo = new File("MeuPrimeiroArquivo.txt");
		
		System.out.println(arquivo.getAbsolutePath());
		System.out.println(arquivo.exists());
		System.out.println(arquivo.canWrite());
		System.out.println(arquivo.isDirectory());
		System.out.println(arquivo.isFile());
		
		if(!arquivo.exists()) {	
			try{
				arquivo.createNewFile();
			}catch(IOException e) {
				
			}
		}
	}
}
