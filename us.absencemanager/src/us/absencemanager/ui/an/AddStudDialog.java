package us.absencemanager.ui.an;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import us.absencemanager.controller.Controller;
import us.absencemanager.exceptions.AlreadyExistsException;



public class AddStudDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8070663398230850671L;
	private JPanel mainContainer, centerPanel, btnPanel;
	private JLabel idLb, nameLb, emailLb, lNameLb;
	private JTextField idTxt, fNameTxt, lNameTxt, emailTxt;
	private JButton createBtn;
	private GridBagConstraints cons;
	private GridBagLayout gridBag;
	private Controller cont;
	
	public AddStudDialog(JFrame fr, Controller cont){
		super(fr);
		
		this.cont= cont;
		
		mainContainer = (JPanel) this.getContentPane();
		mainContainer.setLayout(new BorderLayout());
		
		//BUTTON CONTAINER
		btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
				
		
		this.addComponents();
		
		mainContainer.add(btnPanel, BorderLayout.SOUTH);
		mainContainer.add(centerPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.pack();
		
	}
	
	private void addComponents(){
		
		cons = new GridBagConstraints();
		gridBag = new GridBagLayout();
		this.addCreateBtn();
		//TEXTFIELDS AND LABELS
		centerPanel = new JPanel();
		centerPanel.setLayout(gridBag);
		
		idLb = new JLabel("Student ID:");
		cons.gridx = 0;
		cons.gridy = 0;
		gridBag.setConstraints(idLb, cons);
		centerPanel.add(idLb);
		
		idTxt = new JTextField("", 10);
		cons.gridx = 1;
		cons.gridy = 0;
		gridBag.setConstraints(idTxt, cons);
		centerPanel.add(idTxt);
		
		nameLb = new JLabel("First name:");
		cons.gridx = 0;
		cons.gridy = 1;
		gridBag.setConstraints(nameLb, cons);
		centerPanel.add(nameLb);
		
		fNameTxt = new JTextField("", 10);
		cons.gridx = 1;
		cons.gridy = 1;
		gridBag.setConstraints(fNameTxt, cons);
		centerPanel.add(fNameTxt);
		
		lNameLb = new JLabel("Last Name:");
		cons.gridx = 0;
		cons.gridy = 2;
		gridBag.setConstraints(lNameLb, cons);
		centerPanel.add(lNameLb);
		
		lNameTxt = new JTextField("",10);
		cons.gridx = 1;
		cons.gridy = 2;
		gridBag.setConstraints(lNameTxt, cons);
		centerPanel.add(lNameTxt);
		
		emailLb = new JLabel("Academic email:");
		cons.gridx = 0;
		cons.gridy = 3;
		gridBag.setConstraints(emailLb, cons);
		centerPanel.add(emailLb);
		
		emailTxt = new JTextField("", 10);
		cons.gridx = 1;
		cons.gridy = 3;
		gridBag.setConstraints(emailTxt, cons);
		centerPanel.add(emailTxt);
	}
	
	private void addCreateBtn(){
		//BUTTON
		createBtn = new JButton("Create");
		btnPanel.add(createBtn);
		
		createBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				 try {
					cont.addStudent(idTxt.getText(), fNameTxt.getText(), lNameTxt.getText(), emailTxt.getText());
					
					JOptionPane.showMessageDialog(null, "Student Created Succesfully", "Success", JOptionPane.INFORMATION_MESSAGE);
					//TEST (Successful)
					for(int i = 0; i< cont.getStudents().size(); i++){
						System.out.println(cont.getStudents().get(i).toString());
						
					}
				} catch (AlreadyExistsException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog (null, "Unable to create student. Student already exists", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	
}