package pjAula3;

public class Livraria {
	public static void main(String [] args) {
		//Object of type Obra instantiation 
		Obra book = new Obra();
		
		book.setCodigo(123);
		book.setTitulo("Java how to Program");
		
		Autor author = new Autor();
		author.setCodigo(365);
		author.setNome("Deitel & Deitel");
		author.setSituacao(true);
		book.setAutor(author);
		
		book.setPreco(178.40f);
		book.setSituacao(true);
		
		System.out.println(book.toString());
		
		Obra anotherObra = new Obra(789, "Data Bases", author, 76.54f, false);
		
		System.out.println(anotherObra.toString());
	}
	
}