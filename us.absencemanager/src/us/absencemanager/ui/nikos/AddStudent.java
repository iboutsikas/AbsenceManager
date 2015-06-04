package us.absencemanager.ui.nikos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddStudent extends JPanel implements ActionListener {

	private JPanel addStContPanel,addStBtPanel,mainPanel;
	private JTextField addStFrNmTf,addStLsNmTf,addStEmTf,addStIdTf;
	private JLabel addStFrNmLb,addStLsNmLb,addStEmLb,addStIdLb;
	private JButton bSave,bCancel;
	
	public AddStudent(){
		super(new BorderLayout());
		addStContPanel=new JPanel();
		addStContPanel.setLayout(new GridLayout(4,4));
		addStBtPanel = new JPanel();
		addStBtPanel.setLayout(new FlowLayout());
		mainPanel=new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		//Create Objects
		addStFrNmTf = new JTextField();
		addStLsNmTf = new JTextField();
		addStEmTf = new JTextField();
		addStIdTf = new JTextField();
		addStIdLb = new JLabel("ID:");
		addStFrNmLb = new JLabel("First name:");
		addStLsNmLb = new JLabel("Last name:");
		addStEmLb = new JLabel("E-mail:");
		bSave=new JButton("Save");
		bCancel=new JButton("Cancel");
		
		addStContPanel.add(addStIdLb);
		addStContPanel.add(addStIdTf);
		addStContPanel.add(addStFrNmLb);
		addStContPanel.add(addStFrNmTf);
		addStContPanel.add(addStLsNmLb);
		addStContPanel.add(addStLsNmTf);
		addStContPanel.add(addStEmLb);
		addStContPanel.add(addStEmTf);
		
		addStBtPanel.add(bCancel);
		addStBtPanel.add(bSave);
		
		mainPanel.add(addStContPanel,BorderLayout.CENTER);
		mainPanel.add(addStBtPanel,BorderLayout.SOUTH);
		this.add(mainPanel,BorderLayout.CENTER);
		this.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
