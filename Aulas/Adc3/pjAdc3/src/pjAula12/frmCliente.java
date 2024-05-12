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
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
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
	JLabel lbNome, lbPessoa, lbCNPJ, lbCPF, lbEmail, lbTelefone, lbData, lbFaturamento, lbEstado, lbStatus;
	JTextField txtNome, txtEmail;
	JFormattedTextField txtCNPJ, txtTelefone, txtCPF, txtData, txtFaturamento;
	JComboBox<String> cbxStatus, cbxPessoa, cbxEstado;
	MaskFormatter mascaraCNPJ, mascaraTelefone, mascaraCPF, mascaraData;
	String status[] = {"Ativo", "Inativo"};
	String pessoa[] = {"Física", "Jurídica"};
	String estados[] = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA","MT", "MS", "MG", "PB", "PR", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SP", "SC", "SE", "TO"};
	JButton btCadastrar, btLimpar, btSair, btConsultar;
	JPanel pnCampos, pnBotoes;
	BorderLayout layout;
	GridLayout gridCampos, gridBotoes;
	File arquivo = new File("Clientes.txt");
	
	public frmCliente() {
		setTitle("Cadastro de Clientes");
		setLayout(layout = new BorderLayout());
		setSize(400, 325);
		setLocation(500, 200);//Posição em que exibe
		
		
		//Passo 2: Instanciação dos Objetos
		pnCampos = new JPanel();
		pnBotoes = new JPanel();
		gridCampos = new GridLayout(10,2);
		gridBotoes = new GridLayout(1,4);
		
		lbNome = new JLabel("Razão Social / Nome ");
		lbPessoa = new JLabel("Pessoa ");
		lbCPF = new JLabel("CPF ");
		lbCNPJ = new JLabel("CNPJ ");
		lbCNPJ.setEnabled(false);
		lbEmail = new JLabel("Email ");
		lbTelefone = new JLabel("Telefone ");
		lbData = new JLabel("Data de Cadastro ");
		lbFaturamento = new JLabel("Faturamento ");
		lbEstado = new JLabel("Estado ");
		lbStatus = new JLabel("Status ");
		
		txtNome = new JTextField(20);
		txtEmail = new JTextField(20);
		
		try {
			mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
			mascaraTelefone = new MaskFormatter("(##)####-####");
			mascaraCPF = new MaskFormatter("###.###.###-##");
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			System.err.println("Falha na Máscara.");
		}
		txtCPF  = new JFormattedTextField(mascaraCPF);
		txtCNPJ = new JFormattedTextField(mascaraCNPJ);
		txtCNPJ.setEnabled(false);
		txtTelefone = new JFormattedTextField(mascaraTelefone);
		txtData = new JFormattedTextField(mascaraData);

		txtFaturamento = new JFormattedTextField(NumberFormat.getCurrencyInstance().format(.00));
		
		String data = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());
		txtData.setText(data);
		
		cbxStatus = new JComboBox<String>(status);
		cbxPessoa = new JComboBox<String>(pessoa);
		cbxPessoa.addActionListener(this);
		cbxEstado = new JComboBox<String>(estados);
		
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
		pnCampos.add(lbPessoa);
		pnCampos.add(cbxPessoa);
		pnCampos.add(lbCPF);
		pnCampos.add(txtCPF);
		pnCampos.add(lbCNPJ);
		pnCampos.add(txtCNPJ);
		pnCampos.add(lbEmail);
		pnCampos.add(txtEmail);
		pnCampos.add(lbTelefone);
		pnCampos.add(txtTelefone);
		pnCampos.add(lbData);
		pnCampos.add(txtData);
		pnCampos.add(lbFaturamento);
		pnCampos.add(txtFaturamento);
		pnCampos.add(lbEstado);
		pnCampos.add(cbxEstado);
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
			frmConsulta consulta = new frmConsulta(arquivo);
			consulta.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		if(e.getSource() == btLimpar) {
			setLimpar();
		}
		if(e.getSource() == btSair) {
			System.exit(0);
		}
		//Ao trocar o item selecionado na comboBox pessoa
		if(e.getSource() == cbxPessoa) {
			//Se o item selecionado é a string "Jurídica"
			if((cbxPessoa.getSelectedItem().toString()).equals(pessoa[1])){
				//Troca o campo de texto que aparece de CPF para CNPJ
				lbCNPJ.setEnabled(true);
				txtCNPJ.setEnabled(true);
				lbCPF.setEnabled(false);
				txtCPF.setEnabled(false);
				txtCPF.setText("");
				txtCNPJ.setText("");
			}else {
				//Senão troca o campo de texto que aparece de CNPJ para CPF
				lbCNPJ.setEnabled(false);
				txtCNPJ.setEnabled(false);
				txtCNPJ.setText("");
				txtCPF.setText("");
				lbCPF.setEnabled(true);
				txtCPF.setEnabled(true);
			}
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
			if(cbxPessoa.getSelectedIndex() == 0) {
				out.print("Pessoa Física");
				out.print(" | ");
				out.print(txtCPF.getText());
			}else {				
				out.print("Pessoa Jurídica");
				out.print(" | ");
				out.print(txtCNPJ.getText());
			}
			out.print(" | ");
			out.print(txtEmail.getText());
			out.print(" | ");
			out.print(txtTelefone.getText());
			out.print(" | ");
			out.print(txtData.getText());
			out.print(" | ");
			out.print(txtFaturamento.getText());
			out.print(" | ");
			out.print(estados[cbxEstado.getSelectedIndex()]);
			out.print(" | ");
			out.println(status[cbxStatus.getSelectedIndex()]);
			out.close();
			
			JOptionPane.showMessageDialog(null, "Inclusão Realizada com Sucesso!", "Inclusão no Arquivo Texto", JOptionPane.INFORMATION_MESSAGE);
			setLimpar();
		}catch(IOException exe) {
			JOptionPane.showMessageDialog(null, "Erro na manipuação do Arquivo Texto." + exe, "Erro no Arquivo Texto", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//Método para validar os campos inseridos;
	public boolean validarCampos() {
		//Verifica se os campos foram preenchidos
		if(txtNome.getText().equals("") || txtEmail.getText().equals("") || txtTelefone.getText().equals("(  )    -    ") || txtData.getText().equals("  /  /    ")) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos.", "Validação", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		//Se o usuario não inserir nem o cnpj nem o cpf mostra mensagem que pede para preencher.
		if(txtCNPJ.getText().equals("  .   .   /    -  ") && txtCPF.getText().equals("   .   .   -  ")) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos.", "Validação", JOptionPane.ERROR_MESSAGE);
			return false;	
		}
		/*	Validação de email:
		 * Consiste de uma expressão regular que impõe as seguintes restrições à string email:
		 * 
		 * Exige que exista um arroba "@" no meio da string
		 * Permite letras de A - Z maiúsculas e minúsculas e números de 0 - 9
		 * Permite sublinhado "_" e ponto "."
		 * Ponto "." não é permitido no início nem no fim da string
		 * Não é permitidos pontos "." consecutivos
		 * Deve haver um domínio
		 * Máximo de 64 caracteres
		 */
		Pattern restricao = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
		Matcher email = restricao.matcher(txtEmail.getText());
		if(!(email.find())) {
			JOptionPane.showMessageDialog(null, "Insira um Email válido. Padrão: usuario@domínio", "Validação", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		//Validação da data:
		try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false);
            formato.parse(txtData.getText());
        } catch (ParseException e) {
        	JOptionPane.showMessageDialog(null, "Insira uma Data válida", "Validação", JOptionPane.ERROR_MESSAGE);
			return false;
        }
		/*	Validação de faturamento:
		 * Consiste de uma expressão regular que impões as seguintes restrições:
		 * Primeiro caractere deve ser um R
		 * Segundo caractere deve ser um $
		 * Terceiro caractere deve ser um espaço em branco ou caractere 160(ascii) que está presente na máscara NumberFormat
		 * A string deve conter uma vírgula (,) seguida por caracteres numéricos
		 * Último caractere deve ser um número
		 */
		restricao = Pattern.compile("^(R\\$)(\\s|\\xA0)(\\d*)(,)(\\d{2})$");
		Matcher faturamento = restricao.matcher(txtFaturamento.getText());
		if(!(faturamento.find())) {
			JOptionPane.showMessageDialog(null, "Insira um Faturamento válido\nPadrão: R$ 0,00", "Validação", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void setLimpar() {
		txtNome.setText("");
		cbxPessoa.setSelectedIndex(0);
		txtCNPJ.setText("");
		txtCPF.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		String data = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());
		txtData.setText(data);
		txtFaturamento.setText((NumberFormat.getCurrencyInstance().format(.00)));
		cbxEstado.setSelectedIndex(0);
		cbxStatus.setSelectedIndex(0);
		txtNome.requestFocus();
	}

	public static void main(String[] args) {
		new frmCliente().setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
