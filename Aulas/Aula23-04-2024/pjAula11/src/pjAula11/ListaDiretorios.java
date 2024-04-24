package pjAula11;

import java.io.File;

public class ListaDiretorios {
	public static void main(String[] args) {
		File diretorio = new File("C:\\");
		if(diretorio.isDirectory()) {
			String [] arquivos = diretorio.list();
			for (int i = 0; i < arquivos.length; i++) {
				File f = new File(arquivos[i]);
				System.out.println((f.isDirectory()?"Diretorio ":"Arquivo ") + arquivos[i]);
			}
		}
	}
}