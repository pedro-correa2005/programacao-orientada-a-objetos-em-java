package pjAula11;

import java.io.File;

public class PrimeiroTexto {
	public static void main(String[] args) {
		//String informacoes = "";
		//File arquivo = new File("../pjAula11/MeuPrimeiroArquivo.txt");
		
		/*System.out.println(arquivo.getAbsolutePath());
		System.out.println(arquivo.exists());
		System.out.println(arquivo.canWrite());
		System.out.println(arquivo.isDirectory());
		System.out.println(arquivo.isFile());*/
		
		File integracao = new File("integra");
		
		if(integracao.exists()) {
			System.out.println("Arquivo existe");
		}else {
			integracao.mkdirs();
		}
		System.out.println(integracao.exists()?"Existe":"Não existe");
		
	}
}
