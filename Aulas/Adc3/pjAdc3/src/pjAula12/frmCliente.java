package pjAula12;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class frmCliente extends JFrame implements ActionListener {
	//Passo 1 - Declaração dos Objetos
	JLabel lbNome, lbCNPJ, lbEmail, lbTelefone, lbStatus;
	JTextField txtNome, txtEmail;
	JFormattedTextField txtCNPJ, txtTelefone;
	JComboBox<String> cbxStatus;
	MaskFormatter mascaraCNPJ, mascaraTelefone;
	String status[] = {"Ativo", "Inativo"};
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
		gridCampos = new GridLayout(5,2);
		gridBotoes = new GridLayout(1,4);
		
		lbNome = new JLabel("Razão Social ");
		lbCNPJ = new JLabel("CNPJ ");
		lbEmail = new JLabel("Email ");
		lbTelefone = new JLabel("Telefone ");
		lbStatus = new JLabel("Status ");
		
		txtNome = new JTextField(20);
		txtEmail = new JTextField(20);
		
		try {
			mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
			mascaraTelefone = new MaskFormatter("(##)####-####");
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
		pnBotoes.setLayout(gridBotoes);
		
		//Passo 3 adicionar os campos à Frame
		pnCampos.add(lbNome);
		pnCampos.add(txtNome);
		pnCampos.add(lbCNPJ);
		pnCampos.add(txtCNPJ);
		pnCampos.add(lbEmail);
		pnCampos.add(txtEmail);
		pnCampos.add(lbTelefone);
		pnCampos.add(txtTelefone);
		pnCampos.add(lbStatus);
		pnCampos.add(cbxStatus);
		add(pnCampos, BorderLayout.NORTH);
		
		pnBotoes.add(btCadastrar);
		pnBotoes.add(btLimpar);
		pnBotoes.add(btConsultar);
		pnBotoes.add(btSair);
		add(pnBotoes, BorderLayout.SOUTH);
		
		setResizable(false);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btCadastrar) {
			cadastrar();
		}
		if(e.getSource() == btConsultar) {
			//TODO
			frmConsulta consulta = new frmConsulta(arquivo);
			consulta.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		if(e.getSource() == btLimpar) {
			setLimpar();
		}
		if(e.getSource() == btSair) {
			System.exit(0);
		}
	}
	
	public void cadastrar() {
		if(!validarCampos()) {
			return;
		}
		try {
			//Se o arquivo não existir, cria.
			if(!arquivo.exists()) {
				OutputStream f0 = new FileOutputStream("Clientes.txt");
			}
			PrintWriter out = new PrintWriter(new FileWriter(arquivo, true));
			out.print(txtNome.getText());
			out.print(" | ");
			out.print(txtCNPJ.getText());
			out.print(" | ");
			out.print(txtEmail.getText());
			out.print(" | ");
			out.print(txtTelefone.getText());
			out.print(" | ");
			out.print(status[cbxStatus.getSelectedIndex()]);
			out.print("\n");
			out.close();
			
			JOptionPane.showMessageDialog(null, "Inclusão Realizada com Sucesso!", "Inclusão no Arquivo Texto", JOptionPane.INFORMATION_MESSAGE);
			setLimpar();
		}catch(IOException exe) {
			JOptionPane.showMessageDialog(null, "Erro na manipuação do Arquivo Texto." + exe, "Erro no Arquivo Texto", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//Método para validar os campos inseridos;
	public boolean validarCampos() {
		if(txtNome.getText().equals("") || txtEmail.getText().equals("") || txtTelefone.getText().equals("(  )    -    ")) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos.", "Validação", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		/*if(txtCNPJ.getText().equals("") && txtCpf.getText().equals("")) {
			
		}*/
		/*	Validação de email:
		 * Consiste de uma expressão regular que impõe as seguintes restrições à string email:
		 * 
		 * Exige que exista um arroba "@" no meio da string
		 * Permite letras de A - Z maiúsculas e minúsculas e números de 0 - 9
		 * Permite sublinhado "_" e ponto "."
		 * Ponto "." não é permitido no início nem no fim da string
		 * Não é permitidos pontos "." consecutivos
		 * Máximo de 64 caracteres
		 */
		String email = txtEmail.getText();
		String restricao = new String("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
		if(!(Pattern.compile(restricao).matcher(email).matches())) {
			JOptionPane.showMessageDialog(null, "Insira um Email válido", "Validação", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	private void setLimpar() {
		txtNome.setText("");
		txtCNPJ.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		cbxStatus.setSelectedIndex(0);
		txtNome.requestFocus();
	}

	public static void main(String[] args) {
		new frmCliente().setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
