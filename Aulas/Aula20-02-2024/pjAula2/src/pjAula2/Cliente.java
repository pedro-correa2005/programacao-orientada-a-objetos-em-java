package pjAula2;

public class Cliente {
	//Atributos
	private String nome;
	private float telefone;
	private String email;
	
	
	//M�todos getters e setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setTelefone(float telefone) {
		this.telefone = telefone;
	}
	
	public float getTelefone() {
		return telefone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String info() {
		return "Cliente:\n" + "Nome: " + this.nome + "\nTelefone: " + this.telefone + "\nEmail: " + this.email;
	}
	
	
}