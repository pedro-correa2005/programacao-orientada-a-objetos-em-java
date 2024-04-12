package pjAula1;
/**
 * @author Pedro Henrique Lima Corrêa
 * @data 06/02/2024
 * Classe de Modelagem conceitual de Produto
 */
public class Produto {

	//Atributos
	private int codigo;
	private String descricao;
	private float quantidade;

	//Métodos
	public void incluir(int id, String nome, float valor) {
		codigo = id;
		descricao = nome;
		quantidade = valor;
	}

	public void excluir() {
		//atividade de exclusão
	}
	
	public static void main(String[] args) {
		System.out.println("Olá mundo!");
	}
}