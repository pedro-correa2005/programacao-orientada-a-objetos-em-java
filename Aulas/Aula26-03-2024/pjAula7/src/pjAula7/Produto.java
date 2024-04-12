package pjAula7;

/** Classe de Modelagem Conceitual de Produto
 * @date 26/03/2024
 * @author Pedro H. L. Corrêa
 */
public class Produto {
	//Atributos
	private int codigo;
	private String descricao;
	private float quantidade;
	private boolean status;
	
	//Métodos Getters e Setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Código " + this.getCodigo() + " Descrição: " + this.getDescricao()
		+ " Quantidade: " + this.getQuantidade() + (this.isStatus()?" Ativo ":" Inativo ");
	}
}