package us.absencemanager.ui.ad;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class AddStudDialog extends JDialog {

	private JPanel mainContainer, centerPanel, btnPanel;
	private JLabel idLb, nameLb, emailLb;
	private JTextField idTxt, nameTxt, emailTxt;
	private JButton createBtn;
	
	public AddStudDialog(JFrame fr){
		super(fr);
		
		mainContainer = (JPanel) this.getContentPane();
		mainContainer.setLayout(new BorderLayout());
		
		this.addComponents();
		
		mainContainer.add(btnPanel, BorderLayout.SOUTH);
		mainContainer.add(centerPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
		this.pack();
		
	}
	
	private void addComponents(){
		//BUTTON CONTAINER
		btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		//BUTTON
		createBtn = new JButton("Create");
		btnPanel.add(createBtn);
		//TEXTFIELDS AND LABELS
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridBagLayout());
		
		idLb = new JLabel("Student ID:");
		centerPanel.add(idLb);
		
		idTxt = new JTextField("", 7);
		centerPanel.add(idTxt);
		
		nameLb = new JLabel("Student name:");
		centerPanel.add(nameLb);
		
		nameTxt = new JTextField("", 30);
		centerPanel.add(nameTxt);
		
		emailLb = new JLabel("Academic email:");
		centerPanel.add(emailLb);
		
		emailTxt = new JTextField("", 20);
		centerPanel.add(emailTxt);
	}
	
}