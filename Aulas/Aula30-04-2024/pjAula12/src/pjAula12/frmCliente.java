package pjAula12;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class frmCliente extends JFrame implements ActionListener {
	//Passo 1 - Declaração dos Objetos
	JLabel lbNome, lbCNPJ, lbTelefone, lbStatus;
	JTextField txtNome;
	JFormattedTextField txtCNPJ, txtTelefone;
	JComboBox<String> cbxStatus;
	MaskFormatter mascaraCNPJ, mascaraTelefone;
	String status[] = {"Ativo", "Incativo"};
	JButton btCadastrar, btLimpar, btSair, btConsultar;
	JPanel pnCampos, pnBotoes;
	BorderLayout layout;
	GridLayout gridCampos, gridBotoes;
	File arquivo = new File("Clientes.txt");
	
	public frmCliente() {
		setTitle("Cadastro de Clientes");
		setLayout(layout = new BorderLayout());
		setSize(400, 300);
		setLocation(50, 50);//Posição em que exibe
		
		pnCampos = new JPanel();
		pnBotoes = new JPanel();
		gridCampos = new GridLayout(4,2);
		gridBotoes = new GridLayout(1,4);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new frmCliente().setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
