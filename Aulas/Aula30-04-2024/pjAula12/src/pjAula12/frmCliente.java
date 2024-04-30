package pjAula12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class frmCliente extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5605309577879457528L;
	JLabel lbNome, lbCNPJ, lbTelefone, lbStatus;
	JTextField txtNome;
	JFormattedTextField txtCNPJ, txtTelefone;
	JComboBox<String> cbxStatus;
	MaskFormatter mascaraCNPJ, mascaraTelefone;
	String status[] = {"Ativo", "Incativo"};
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
