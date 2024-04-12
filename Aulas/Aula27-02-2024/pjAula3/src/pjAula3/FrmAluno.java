package pjAula3;


import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrmAluno extends JFrame{
	//1 Step Declare Object
	JButton btCadastrar, btLimpar;
	JTextField txtNome, txtTelefone;
	JLabel lbNome, lbTelefone;
	
	public FrmAluno(){
		super("Exemplo");
		setSize(300, 300);
		setLayout(new FlowLayout());
		
		//2 Step instantiate object
		btCadastrar = new JButton("Cadastrar");
		btLimpar = new JButton("Limpar");
		txtNome = new JTextField(20);
		txtTelefone = new JTextField(20);
		lbNome = new JLabel("Nome");
		lbTelefone = new JLabel("Telefone");
		
		//3 Step add object on the screen
		add(lbNome);
		add(txtNome);
		add(lbTelefone);
		add(txtTelefone);
		add(btCadastrar);
		add(btLimpar);
		
		setVisible(true);
	}
	
	
	public static void main(String [] args) {
		FrmAluno form = new FrmAluno();
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
