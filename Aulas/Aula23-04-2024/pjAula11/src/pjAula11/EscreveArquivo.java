package pjAula11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EscreveArquivo {

	public static void main(String[] args) {
		String texto = "Glowing windows in the buildings from the elevated train\n"
				+ "I see a thousand different stories pass\n"
				+ "Faces without names\n"
				+ "Forget why I came here, and I forget why I stay\n"
				+ "And I wonder if they noticed,\n"
				+ "If I slipped away\n"
				+ "\n"
				+ "What if I kept going?\n"
				+ "What if I don't get off tonight?\n"
				+ "What if I ride this to the edges?\n"
				+ "Through the darkness, to the light\n"
				+ "Could I find you? There?\n"
				+ "Could I find you? There?\n"
				+ "If I slipped away?\n"
				+ "\n"
				+ "What if there's no answers we're all just hearts that have to fight\n"
				+ "Through the dangers of the rapids\n"
				+ "Through the darkness, to the light\n"
				+ "Could I find you? There?\n"
				+ "Could I find you? There?\n"
				+ "If I slipped away?\n";
		
		String nome_arq = "memoria.txt";
		File tstArquivo = new File(nome_arq);
		
		if(!tstArquivo.exists()) {
			try {
				tstArquivo.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		//Estrutura para Escrita
		try {
			FileWriter arquivoSaida = new FileWriter(nome_arq);
			BufferedWriter buffer = new BufferedWriter(arquivoSaida);
			buffer.write(texto);
			buffer.close();
		}catch(IOException e) {
			System.err.println("Erro ao abrir o arquivo");
		}
		
		//Estrutura parpa Leitura
		try {
			FileReader arquivoLeitura = new FileReader(nome_arq);
			BufferedReader buffer = new BufferedReader(arquivoLeitura);
			String saida = buffer.readLine();
			while(saida != null) {
				System.out.println(saida);
				saida = buffer.readLine();
			}
			buffer.close();
		}catch(IOException e) {
			System.err.println("Erro ao ler arquivo");
		}
		
	}

}
