package br.unisal.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.unisal.modelagem.Produto;
import br.unisal.modelagem.Situacao;
import br.unisal.modelagem.UnidadeMedida;

public class FrmProduto extends JFrame implements ActionListener {
	//Declaração da lista de produtos para o CRUD
	List<Produto> bdProduto = new ArrayList<Produto>();
	
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
		setSize(400, 200);
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
		
		//Campos de texto
		txtCodigo = new JTextField();
		txtDescricao = new JTextField();
		txtLargura = new JTextField();
		txtComprimento = new JTextField();
		txtLocalizacao = new JTextField();

		//ComboBox
		cbxSituacao = new JComboBox<Situacao>(Situacao.values());
		cbxUnidadeMedida = new JComboBox<String>(UnidadeMedida.getUnidades());
		
		//Botões
		btnInclui = new JButton("Incluir");
		btnAltera = new JButton("Alterar");
		btnExclui = new JButton("Excluir");
		btnPesquisa = new JButton("Pesquisar");
		
		//Painéis
		pnCampos = new JPanel(new GridLayout(7,2));
		pnBotoes = new JPanel(new GridLayout(1,4));
		
		//Passo 3: Adicionar os campos à tela
		pnCampos.add(lbCodigo);
		pnCampos.add(txtCodigo);
		pnCampos.add(lbDescricao);
		pnCampos.add(txtDescricao);
		pnCampos.add(lbUnidadeMedida);
		pnCampos.add(cbxUnidadeMedida);
		pnCampos.add(lbLargura);
		pnCampos.add(txtLargura);
		pnCampos.add(lbComprimento);
		pnCampos.add(txtComprimento);
		pnCampos.add(lbSituacao);
		pnCampos.add(cbxSituacao);
		pnCampos.add(lbLocalizacao);
		pnCampos.add(txtLocalizacao);
		
		add(pnCampos, BorderLayout.CENTER);
		
		pnBotoes.add(btnInclui);
		pnBotoes.add(btnAltera);
		pnBotoes.add(btnExclui);
		pnBotoes.add(btnPesquisa);
		
		add(pnBotoes, BorderLayout.SOUTH);
		
		//Passo 4: Incluir os elementos no Listener de Ações
		btnInclui.addActionListener(this);
		btnAltera.addActionListener(this);
		btnExclui.addActionListener(this);
		btnPesquisa.addActionListener(this);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnInclui) {
			bdProduto.add(instanciar());
		}
		if(e.getSource() == btnAltera) {
			for(Produto p: bdProduto) {
				if(p.getCodigo() == p.getCodigo()) {
					p = instanciar();
				}
			}
		}
		System.out.println(bdProduto);
	}
	
	private Produto instanciar() {
		Produto p = new Produto();
		try {
			p.setCodigo(Integer.parseInt(txtCodigo.getText()));
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Código do Produto Inválida", "Validação", JOptionPane.ERROR_MESSAGE);
		}
		
		p.setDescricao(txtDescricao.getText());
		p.setUn(UnidadeMedida.values()[cbxUnidadeMedida.getSelectedIndex()]);
		
		try {
			p.setLargura(Float.parseFloat(txtLargura.getText()));
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Largura do Produto Inválida", "Validação", JOptionPane.ERROR_MESSAGE);
		}
		
		try {
			p.setComprimento(Float.parseFloat(txtComprimento.getText()));
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Comprimento do Produto Inválida", "Validação", JOptionPane.ERROR_MESSAGE);
		}
		
		p.setSituacao(Situacao.values()[cbxSituacao.getSelectedIndex()]);
		p.setLocalizacao(txtLocalizacao.getText());
		return p;
	}

	public static void main(String[] args) {
		new FrmProduto().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
