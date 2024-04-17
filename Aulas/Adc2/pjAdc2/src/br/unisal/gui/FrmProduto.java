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
	JButton btnInclui, btnExclui, btnAltera, btnPesquisa, btnLimpa;
	
	public FrmProduto() {
		super("Cadastro de Produto");
		setSize(500, 200);
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
		btnLimpa = new JButton("Limpar");
		
		btnAltera.setEnabled(false);
		btnExclui.setEnabled(false);
		
		//Painéis
		pnCampos = new JPanel(new GridLayout(7,2));
		pnBotoes = new JPanel(new GridLayout(1,5));
		
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
		pnBotoes.add(btnLimpa);
		
		add(pnBotoes, BorderLayout.SOUTH);
		
		//Passo 4: Incluir os elementos no Listener de Ações
		btnInclui.addActionListener(this);
		btnAltera.addActionListener(this);
		btnExclui.addActionListener(this);
		btnPesquisa.addActionListener(this);
		btnLimpa.addActionListener(this);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnInclui) {
			incluir();
		}
		if(e.getSource() == btnAltera) {
			alterar();
		}
		if(e.getSource() == btnPesquisa) {
			pesquisar();
		}
		if(e.getSource() == btnExclui) {
			excluir();
		}
		if(e.getSource() == btnLimpa) {
			limpar();
		}
	}
	
	private void incluir() {
		//Instancia novo produto
		Produto produto = instanciar();
		//Caso a instanciação seja bem-sucedida
		if(produto != null) {
			//Adiciona o produto à lista e volta formulário para o estado
			//original
			bdProduto.add(produto);
			limpar();
		}
	}
	
	private void alterar() {
		//Declara novo produto que possirá os atributos a serem modificados
		Produto produtoAlterado;
		//Guarda o código inserido na pesquisa
		int cod = Integer.parseInt(txtCodigo.getText());
		//Percorre a lista de produtos
		for(Produto p: bdProduto) {
			//Encontra produto com o mesmo código que o código inserido
			if(p.getCodigo() == cod) {
				//Instancia novo produto
				produtoAlterado = instanciar();
				//Caso a instanciação seja bem-sucedida
				if(produtoAlterado != null) {
					//O produto na lista recebe os atributos do "novo" produto
					p.setDescricao(produtoAlterado.getDescricao());
					p.setUn(produtoAlterado.getUn());
					p.setLargura(produtoAlterado.getLargura());
					p.setComprimento(produtoAlterado.getComprimento());
					p.setSituacao(produtoAlterado.getSituacao());
					p.setLocalizacao(produtoAlterado.getLocalizacao());
					//O formulário volta para o estado original
					limpar();
					
					JOptionPane.showMessageDialog(null, "Produto alterado com sucesso", "Alteração", JOptionPane.INFORMATION_MESSAGE);
					return;
				}else {
					//Caso a instanciação seja mal-sucedida, interrompe o método
					return;
				}
			}
		}
		//Caso não encontre o produto o formulário volta para o estado original
		limpar();
		JOptionPane.showMessageDialog(null, "Não foi possível alterar o produto\nVerifique o código do produto e tente novamente", "Alteração", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void excluir() {
		//Percorre a lista de produtos
		for(Produto p: bdProduto) {
			//Encontra produto com o mesmo código que o código inserido
			if(p.getCodigo() == Integer.parseInt(txtCodigo.getText())) {
				//Exclui o produto
				p.setSituacao(Situacao.EXCLUIDO);
				
				//Volta o formulário para o estado original
				limpar();
				JOptionPane.showMessageDialog(null, "Produto excluído com sucesso", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		}
	}
	
	private void pesquisar() {
		//Se há uma pesquisa carregada, volta o formulário para o estado
		//original e encerra o método
		if(!(txtCodigo.isEnabled())) {
			limpar();
			return;
		}
		
		//Se a lista está vazia encerra o método
		if(bdProduto.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado.", "Pesquisa", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		int cod;
		//Lê o código inserido e o guarda na variável cod
		try {
			cod = Integer.parseInt(txtCodigo.getText());
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Código do Produto Inválido", "Validação", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//Percorre a lista buscando por um produto com o mesmo código que o
		//código inserido
		for(Produto p: bdProduto) {
			//Caso o produto seja encontrado, coloca todas as informações
			//nos campos e habilita o botão de alterar desabilita o botão de
			//incluir e o campo de código, por útimo, sai do método
			if(p.getCodigo() == cod) {
				txtDescricao.setText(p.getDescricao());
				
				cbxUnidadeMedida.setSelectedItem(p.getUn().getUnidade()+ " - " + p.getUn().getDescricao());
				
				txtLargura.setText(Float.toString(p.getLargura()));
				
				txtComprimento.setText(Float.toString(p.getComprimento()));
				
				cbxSituacao.setSelectedItem(p.getSituacao());
				
				txtLocalizacao.setText(p.getLocalizacao());
				
				btnAltera.setEnabled(true);
				
				//Caso o produto já esteja excluido o botão excluir 
				//permanece desabilitado caso contrário é habilitado
				if(p.getSituacao() != Situacao.EXCLUIDO) {
					btnExclui.setEnabled(true);
				}
				
				btnInclui.setEnabled(false);
				txtCodigo.setEnabled(false);
				
				JOptionPane.showMessageDialog(null, "Produto localizado com sucesso", "Pesquisa", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		}
		//Caso não encontre o produto o método chegará ao fim
		JOptionPane.showMessageDialog(null, "Produto não localizado.", "Pesquisa", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void limpar() {
		//O formulário volta para o estado original
		btnInclui.setEnabled(true);
		txtCodigo.setEnabled(true);
		btnExclui.setEnabled(false);
		btnAltera.setEnabled(false);
		
		txtCodigo.setText("");
		txtDescricao.setText("");
		txtComprimento.setText("");
		txtLargura.setText("");
		txtLocalizacao.setText("");
		cbxSituacao.setSelectedIndex(0);
		cbxUnidadeMedida.setSelectedIndex(0);
	}
	
	private Produto instanciar() {
		Produto p = new Produto();
		try {
			p.setCodigo(Integer.parseInt(txtCodigo.getText()));
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Código do Produto Inválido", "Validação", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		p.setDescricao(txtDescricao.getText());
		p.setUn(UnidadeMedida.values()[cbxUnidadeMedida.getSelectedIndex()]);
		
		try {
			p.setLargura(Float.parseFloat(txtLargura.getText()));
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Largura do Produto Inválida", "Validação", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		try {
			p.setComprimento(Float.parseFloat(txtComprimento.getText()));
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Comprimento do Produto Inválido", "Validação", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		p.setSituacao(Situacao.values()[cbxSituacao.getSelectedIndex()]);
		p.setLocalizacao(txtLocalizacao.getText());
		return p;
	}

	public static void main(String[] args) {
		new FrmProduto().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
