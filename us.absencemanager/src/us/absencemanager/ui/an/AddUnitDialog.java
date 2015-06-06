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

/**
 * @authors Athanasios Doulgeris , Nikolaos Doumpalas
 *
 */
public class AddUnitDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8783256229633658776L;
	private JPanel mainContainer, btnPanel, centerPanel;
	private JButton createBtn;
	private JLabel idLb, titleLb, maxAbsLb;
	private JTextField idTxt, titleTxt, maxAbsTxt;
	private GridBagConstraints cons;
	private GridBagLayout gridBag;
	private Controller cont;
	
	/**
	 * @param fr
	 * @param cont
	 */
	public AddUnitDialog(JFrame fr, Controller cont){
		super(fr);
		this.cont = cont;
		mainContainer = (JPanel) this.getContentPane();
		mainContainer.setLayout(new BorderLayout());
		
		this.addComponents();
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.pack();
		
	}
	
	/**
	 * 
	 */
	private void addComponents(){
		//BUTTON CONTAINER
		this.btnPanel = new JPanel();
		this.btnPanel.setLayout(new FlowLayout());
		this.mainContainer.add(btnPanel, BorderLayout.SOUTH);
		
		this.createBtn = new JButton("Create");
		this.btnPanel.add(createBtn);
		
		this.centerPanel = new JPanel();
		this.mainContainer.add(centerPanel, BorderLayout.CENTER);
		
		this.addCenterComponents();
		this.addListeners();
	}

	/**
	 * 
	 */
	private void addCenterComponents() {
		
		cons = new GridBagConstraints();
		gridBag = new GridBagLayout();
		this.centerPanel.setLayout(gridBag);
		

		//TEXTFIELDS AND LABELS
		
		idLb = new JLabel("Unit ID:");
		cons.gridx = 0;
		cons.gridy = 0;
		gridBag.setConstraints(idLb, cons);
		centerPanel.add(idLb);
		
		idTxt = new JTextField("", 10);
		cons.gridx = 1;
		cons.gridy = 0;
		gridBag.setConstraints(idTxt, cons);
		centerPanel.add(idTxt);
		
		titleLb = new JLabel("Unit title:");
		cons.gridx = 0;
		cons.gridy = 1;
		gridBag.setConstraints(titleLb, cons);
		centerPanel.add(titleLb);
		
		titleTxt = new JTextField("", 10);
		cons.gridx = 1;
		cons.gridy = 1;
		gridBag.setConstraints(titleTxt, cons);
		centerPanel.add(titleTxt);		
		
		maxAbsLb = new JLabel("Maximum Absences:");
		cons.gridx = 0;
		cons.gridy = 2;
		gridBag.setConstraints(maxAbsLb, cons);
		centerPanel.add(maxAbsLb);
		
		maxAbsTxt = new JTextField("", 10);
		cons.gridx = 1;
		cons.gridy = 2;
		gridBag.setConstraints(maxAbsTxt, cons);
		centerPanel.add(maxAbsTxt);	
	}
	
	/**
	 * 
	 */
	private void addListeners(){
		createBtn.addActionListener(new ActionListener(){
			int maxAbsences = -1;
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					maxAbsences = Integer.parseInt(maxAbsTxt.getText());
					
					try {
						cont.addUnit(idTxt.getText(), titleTxt.getText(), maxAbsences);
						JOptionPane.showMessageDialog(null, "Unit Created Succesfully", "Success", JOptionPane.INFORMATION_MESSAGE);
					} catch (AlreadyExistsException e1) {
						JOptionPane.showMessageDialog (null, "Unable to create unit. Unit already exists", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2){
					JOptionPane.showMessageDialog (null, "Unable to create unit. Please type in an integer number in the absences field.", "Error", JOptionPane.ERROR_MESSAGE);
			    }	
			}
		});
	}
}
