package us.absencemanager.ui;

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



public class AddStudPanel extends JDialog {

	private JPanel mainContainer, centerPanel, btnPanel;
	private JLabel idLb, nameLb, emailLb;
	private JTextField idTxt, nameTxt, emailTxt;
	private JButton createBtn;
	
	public AddStudPanel(JFrame fr){
		super(fr);
		
		mainContainer = (JPanel) this.getContentPane();
		mainContainer.setLayout(new BorderLayout());
		
		btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		
		createBtn = new JButton("Create");
		btnPanel.add(createBtn);
		mainContainer.add(btnPanel, BorderLayout.SOUTH);
		
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
		
		mainContainer.add(centerPanel, BorderLayout.CENTER);
		this.setVisible(true);
		this.pack();
		
	}
	
}
