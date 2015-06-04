package us.absencemanager.ui.nikos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EditAbsencesCont extends JPanel implements ActionListener{
	
	private JPanel addAbsBtPanel,addAbsContPanel,mainPanel;
	private JLabel addAbsTitLb,addAbsOrpLb;
	private JButton bEdit,bCancel;

	EditAbsences editAbsences;
	EditAbsencesCont addAbsencesCont;
	public EditAbsencesCont(){
		super();
		//Create Panels
		addAbsBtPanel = new JPanel();
		addAbsBtPanel.setLayout(new GridLayout(0,3));
		addAbsContPanel = new JPanel();
		addAbsContPanel.setLayout(new BorderLayout());
		mainPanel=new JPanel();
		mainPanel.setLayout(new BorderLayout());		
		
		addAbsTitLb = new JLabel("Edit Absences");
		addAbsOrpLb=new JLabel("CCP 1220-Object Oriented Programming");
		bEdit = new JButton("Edit");
		bCancel = new JButton("Cancel");
		
		addAbsBtPanel.add(addAbsOrpLb);
		addAbsBtPanel.add(bCancel);
		addAbsBtPanel.add(bEdit);
		
		
		editAbsences = new EditAbsences();
		//Test
		addAbsContPanel.add(addAbsTitLb,BorderLayout.NORTH);
		addAbsContPanel.add(editAbsences,BorderLayout.CENTER);
		addAbsContPanel.add(addAbsBtPanel,BorderLayout.SOUTH);
		
		mainPanel.add(addAbsContPanel,BorderLayout.CENTER);
		this.add(mainPanel,BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
