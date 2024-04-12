package pjAdc1;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Questão 2 e 3
 * @autor Pedro Henrique Lima Corrêa
 * @data 22/03/2024
 */
public class CadastroVeiculo extends JFrame implements ActionListener{
	
	//Declaração dos componentes da interface
	private JLabel lblPlaca, lblModelo, lblDataCompra, lblFabricante, lblAno, lblValor;
	private JTextField txtPlaca, txtModelo, txtDataCompra, txtAno, txtValor;
	private JComboBox cbFabricante;
	private JPanel pnCampos, pnBotoes;
	private JButton btnCadastrar, btnAlterar, btnExcluir, btnPesquisar, btnLimpar, btnSair;
	
	//Declaração do array de objetos da classe Veiculo
	private Veiculo [] veiculos;
	
	//Array para o seletor de fabricantes
		String marcas [] = {
			"Audi", "BMW", "Chevrolet", "Citroën", "Fiat", "Ford", 
			"Honda", "Hyundai", "Jeep", "Land Rover",  "Mercedes-Benz",
			"Mitsubishi", "Nissan", "Peugeot", "Porsche", "Renault",
			"Toyota", "Volkswagen", "Volvo"
		};
	
	//Método construtor
	public CadastroVeiculo() {
		//Título da janela
		super("Controle de Frota - Cadastro de Veículos");
		
		//Tamanho da janela
		setSize(580,150);
		setResizable(false);
		
		//Construção dos componentes da interface	
		//Labels
		lblPlaca = new JLabel("Placa");
		lblModelo = new JLabel("Modelo");
		lblDataCompra = new JLabel("Data Compra");
		lblFabricante = new JLabel("Fabricante");
		lblAno = new JLabel("Ano");
		lblValor = new JLabel("Valor(R$)");
		
		//Áreas de texto
		txtPlaca = new JTextField(20);
		txtModelo = new JTextField(20);
		txtDataCompra = new JTextField(20);
		txtAno = new JTextField(20);
		txtValor = new JTextField(20);
		
		//Seletor
		cbFabricante = new JComboBox();
		//Adição dos itens do array de fabricantes ao seletor
		for(String m: marcas) {
			cbFabricante.addItem(m);
		}
		
		//Botões
		btnCadastrar = new JButton("Cadastrar");
		btnAlterar = new JButton("Alterar");
		btnExcluir = new JButton("Excluir");
		btnPesquisar = new JButton("Pesquisar");
		btnLimpar = new JButton("Limpar");
		btnSair = new JButton("Sair");
		
		//Painéis
		pnCampos = new JPanel(new GridLayout(3,4));
		pnBotoes = new JPanel(new FlowLayout());
		
		//Adição dos componentes à GUI
		
		//Painel principal
		pnCampos.add(lblPlaca);
		pnCampos.add(txtPlaca);
		pnCampos.add(lblFabricante);
		pnCampos.add(cbFabricante);
		pnCampos.add(lblModelo);
		pnCampos.add(txtModelo);
		pnCampos.add(lblAno);
		pnCampos.add(txtAno);
		pnCampos.add(lblDataCompra);
		pnCampos.add(txtDataCompra);
		pnCampos.add(lblValor);
		pnCampos.add(txtValor);
		
		//Painel de botoes
		pnBotoes.add(btnCadastrar);
		pnBotoes.add(btnAlterar);
		pnBotoes.add(btnExcluir);
		pnBotoes.add(btnPesquisar);
		pnBotoes.add(btnLimpar);
		pnBotoes.add(btnSair);
		
		//Adição e seleção do Layout dos painéis, principal e de botões
		add(pnCampos, new BorderLayout().CENTER);
		add(pnBotoes, new BorderLayout().SOUTH);
		
		//Definição do cursor quando estiver sobre o painel de botoes e sobre o seletor 
		pnBotoes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cbFabricante.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Adição do action listener
		txtModelo.addActionListener(this);
		
		btnCadastrar.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnExcluir.addActionListener(this);
		btnPesquisar.addActionListener(this);
		btnLimpar.addActionListener(this);
		btnSair.addActionListener(this);
		
		//Adição de bordas para separação dos componentes
		lblFabricante.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		lblAno.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		lblValor.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		pnCampos.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 1));
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == txtModelo) {
			txtModelo.setText(txtModelo.getText().toUpperCase());
		}
		if(evento.getSource() == btnCadastrar) {
			try {
				cadastrar();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				txtDataCompra.setText("Data inváldia");
			}
		}
		if(evento.getSource() == btnAlterar) {
			try {
				alterar();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				txtDataCompra.setText("Data inváldia");
			}
		}
		if(evento.getSource() == btnExcluir) {
			excluir();
		}
		if(evento.getSource() == btnPesquisar) {
			pesquisar();
		}
		if(evento.getSource() == btnLimpar) {
			limpar();
		}
		if(evento.getSource() == btnSair) {
			dispose();
		}
	}
	
	private void limpar() {
		txtPlaca.setText("");
		txtModelo.setText("");
		txtDataCompra.setText("");
		txtAno.setText("");
		txtValor.setText("");
	}
	
	//Método pesquisar quando é chamado dentro de outros métodos
	private int pesquisar(String placa) {
		int pos = 0;
		if(veiculos != null) {
			for(Veiculo v: veiculos) {
				if(v.getPlaca().equalsIgnoreCase(placa)) {
					return pos;
				}
				pos++;
			}
		}
		return -1;
	}
	
	//Método pesquisar quando é chamado por um evento
	private void pesquisar(){
		//Coleta placa inserido na area de texto
		String placa = txtPlaca.getText();
		//variavel para encontrar a posição do veiculo no array
		int pos= -1;
		
		//se nao for nulo pesquisa, caso contrário mostra que não há veículos no array
		if(veiculos != null) {
			//Encontra a posição do veiculo com a placa inserida
			for(int i = 0; i < veiculos.length; i++) {
				if(veiculos[i].getPlaca().equalsIgnoreCase(placa)) {
					pos = i;
				}
			}
			//Se não encontrou a placa
			if(pos < 0) {
				limpar();
				txtModelo.setText("Não encontrado");
			}else {//Se encontrou a placa insere as informações do carro nos campos
				txtModelo.setText(veiculos[pos].getModelo());
				
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				txtDataCompra.setText(formato.format(veiculos[pos].getDataCompra()));
				
				
				int i;
				for(i = 0; i < marcas.length; i++) {
					if(marcas[i] == veiculos[pos].getFabricante()) {
						break;
					}
				}
				cbFabricante.setSelectedIndex(i);
				
				txtAno.setText(Integer.toString(veiculos[pos].getAnoFabricacao()));
				txtValor.setText(Float.toString(veiculos[pos].getValor()));
			}
		}else {
			txtModelo.setText("Nenhum veículo cadastrado");
		}
	}

	private void excluir() {
		//encontra a posicao daquele veiculo no array
		int pos = pesquisar(txtPlaca.getText());
		if(pos >= 0) {
			//se existe mais de um veiculo cadastrado
			if(veiculos.length > 1) {
				//Novo array para guardar os dados do array
				Veiculo [] backup = veiculos;
				//Diminui uma posição do array original
				veiculos = new Veiculo[veiculos.length - 1];
				//Controle de posição original
				int posOri = 0;
				//Copiar os dados do array backup para o array original menos o veiculo a excluir
				for(int i = 0; i < backup.length; i++) {
					if(i != pos) {
						veiculos[posOri] = backup[i];
						posOri++;
					}
				}
				limpar();
			}else {
				//Se há apenas 1 veículo anula o array
				veiculos = null;
				limpar();
			}
		}else {
			txtPlaca.setText("Placa não encontrada");
		}
	}

	private void alterar() throws ParseException {
		int pos = pesquisar(txtPlaca.getText());
		if(pos >= 0) {
			veiculos[pos].setModelo(txtModelo.getText());
			
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			Date dataCompra = formato.parse(txtDataCompra.getText());
			veiculos[pos].setDataCompra(dataCompra);
			
			veiculos[pos].setFabricante(marcas[cbFabricante.getSelectedIndex()]);
			veiculos[pos].setAnoFabricacao(Integer.parseInt(txtAno.getText()));
			veiculos[pos].setValor(Float.parseFloat(txtValor.getText()));
			limpar();
		}else {
			txtPlaca.setText("Placa não encontrada");
		}
	}

	private void cadastrar() throws ParseException {
		//Coletando os dados inseridos nas areas de texto
		String placa = txtPlaca.getText();
		String modelo = txtModelo.getText();
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataCompra = formato.parse(txtDataCompra.getText());
		
		String fabricante = marcas[cbFabricante.getSelectedIndex()];
		int anoFabricacao = Integer.parseInt(txtAno.getText());
		float valor = Float.parseFloat(txtValor.getText());
		
		//Inteiro para controlar a posição
		int pos = -1;
		
		//Se o array for nulo
		if(veiculos == null) {
			//criar o array
			veiculos = new Veiculo[1];
			//zera a posição
			pos = 0;
		}else {//ja existe dados no array
			//se a placa se repete
			if(pesquisar(placa) != -1) {
				txtPlaca.setText("Placa repetida");
				return;
			}else {
				//criar novo array e guardar dados do veiulo
				Veiculo [] backup = veiculos;
				//Ampliar o array original em uma posição
				veiculos = new Veiculo[veiculos.length + 1];
				//copiar para o array original
				for(int i = 0; i < backup.length; i++) {
					veiculos[i] = backup[i];
					//organizar a posição
					pos = backup.length;
				}
			}
		}
		veiculos[pos] = new Veiculo(placa, fabricante, modelo, anoFabricacao, valor, dataCompra);
		limpar();
	}

	public static void main(String[] args) {
		CadastroVeiculo cadastro = new CadastroVeiculo();
		cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}