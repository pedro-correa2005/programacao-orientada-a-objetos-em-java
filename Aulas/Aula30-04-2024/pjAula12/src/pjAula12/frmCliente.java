package pjAula12;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;

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
		setLocation(500, 200);//Posição em que exibe
		
		
		//Passo 2: Instanciação dos Objetos
		pnCampos = new JPanel();
		pnBotoes = new JPanel();
		gridCampos = new GridLayout(4,2);
		gridBotoes = new GridLayout(1,4);
		
		lbNome = new JLabel("Razão Social ");
		lbCNPJ = new JLabel("CNPJ ");
		lbTelefone = new JLabel("Telefone ");
		lbStatus = new JLabel("Status ");
		
		txtNome = new JTextField(20);
		
		try {
			mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
			mascaraTelefone = new MaskFormatter("(##)####-#####");
		} catch (ParseException e) {
			System.err.println("Falha na Máscara.");
		}
		
		txtCNPJ = new JFormattedTextField(mascaraCNPJ);
		txtTelefone = new JFormattedTextField(mascaraTelefone);
		
		cbxStatus = new JComboBox<String>(status);
		
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.setMnemonic('C');
		btCadastrar.setToolTipText("Cadastra um cliente");
		btCadastrar.addActionListener(this);
		
		btLimpar = new JButton("Limpar");
		btLimpar.setMnemonic('L');
		btLimpar.setToolTipText("Limpa os campos");
		btLimpar.addActionListener(this);
		
		btSair = new JButton("Sair");
		btSair.setMnemonic('S');
		btSair.setToolTipText("Sai da tela");
		btSair.addActionListener(this);
		
		btConsultar = new JButton("Consultar");
		btConsultar.setMnemonic('T');
		btConsultar.setToolTipText("Consulta cadastro");
		btConsultar.addActionListener(this);
		
		pnCampos.setLayout(gridCampos);
		
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
