package br.unisal.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrmProduto extends JFrame implements ActionListener {
	//Passo 1: Declaração dos componentes da interface
	//Labels
	JLabel lbCodigo, lbDescricao, lbUnidadeMedida, lbLargura, lbComprimento,
		   lbSituacao, lbLocalizacao;
	
	//Campos de texto
	JTextField txtCodigo, txtDescricao, txtLargura, txtComprimento, 
			   txtLocalizacao;
	
	//ComboBox
	JComboBox cbxUnidadeMedida, cbxSituacao;
	
	//Painéis
	JPanel pnCampos, pnBotoes;
	
	//Botões
	JButton btnInclui, btnExclui, btnAltera, btnPesquisa;
	
	public FrmProduto() {
		super("Cadastro de Produto");
		setSize(300, 200);
		setLayout(new BorderLayout());
		
		//Passo 2 Construir os objetos
		//Labels
		lbCodigo = new JLabel("Código");
		lbDescricao = new JLabel("Descrição");
		lbUnidadeMedida = new JLabel("Un. Medida");
		lbLargura = new JLabel("Largura");
		lbComprimento = new JLabel("Comprimento");
		lbSituacao = new JLabel("Situação");
		lbLocalizacao = new JLabel("Localização");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
