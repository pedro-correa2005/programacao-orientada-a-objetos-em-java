package br.unisal.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrmProduto extends JFrame implements ActionListener {
	//Declaração dos componentes da interface
	//Labels
	JLabel lbCodigo, lbDescricao, lbUnidadeMedida, lbLargura, lbComprimento,
		   lbSituacao, lbLocalizacao;
	
	//Campos de texto
	JTextField txtCodigo, txtDescricao, txtLargura, txtComprimento, 
			   txtLocalizacao;
	
	//ComboBox
	JComboBox cbxUnidadeMedida, cbxSituacao;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
