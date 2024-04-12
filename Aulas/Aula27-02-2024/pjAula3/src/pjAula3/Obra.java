package pjAula3;

/**
 * Conceptual Modeling Class for Obras
 * @author Pedro
 * @data 27/02/2024
 */
public class Obra {
	//Attributes
	private int codigo;
	private String titulo;
	private Autor autor;
	private float preco;
	private boolean situacao;
	
	//Constructor Method
	public Obra() {
		//It will be executed as soon as the object is created
		System.out.println("The Object was instantiated");
	}
	
	public Obra(int codigo, String titulo, Autor autor, float preco, boolean situacao) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.preco = preco;
		this.situacao = situacao;
		System.out.println("The Object was instantiated");
	}
	//Methods
	
	//Getter and Setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return 		"Codigo: " + this.getCodigo() + "\n"
				+ 	"Titulo: " + this.getTitulo() + "\n"
				+ 	"Autor: " + this.getAutor().getNome() + "\n"
				+ 	"Pre�o: " + this.getPreco() + "\n";
	}
	
}