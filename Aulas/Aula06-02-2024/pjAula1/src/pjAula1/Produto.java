package pjAula1;
/**
 * @author Pedro Henrique Lima Corr�a
 * @data 06/02/2024
 * Classe de Modelagem conceitual de Produto
 */
public class Produto {

	//Atributos
	private int codigo;
	private String descricao;
	private float quantidade;

	//M�todos
	public void incluir(int id, String nome, float valor) {
		codigo = id;
		descricao = nome;
		quantidade = valor;
	}

	public void excluir() {
		//atividade de exclus�o
	}
	
	public static void main(String[] args) {
		System.out.println("Ol� mundo!");
	}
}