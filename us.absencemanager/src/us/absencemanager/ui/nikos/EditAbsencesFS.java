package us.absencemanager.ui.nikos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class EditAbsencesFS extends JPanel implements ActionListener{
	
	private JPanel mainPanel,addContPanel;
	private JComboBox chGrCb;
	private JLabel chGrLb;
	private JButton bNext;
	private JFrame topFrame ;
	
	EditAbsences editAbsences;
	EditAbsencesCont editAbsencesCont;
	EditAbsencesFS thisObject;
	
	public EditAbsencesFS(){
		super();
		this.setLayout(new BorderLayout());
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		addContPanel=new JPanel();
		addContPanel.setLayout(new GridLayout(1,1));
		
		chGrCb = new JComboBox();
		chGrLb = new JLabel("Group of students");
		bNext = new JButton("Next");
		
		addContPanel.add(chGrLb);
		addContPanel.add(chGrCb);
		
		bNext.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(mainPanel);
				mainPanel = new EditAbsencesCont();
				add(mainPanel,BorderLayout.CENTER);
				topFrame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, EditAbsencesFS.this);
				topFrame.pack();
			}
		});
		
		
		mainPanel.add(addContPanel,BorderLayout.CENTER);
		mainPanel.add(bNext,BorderLayout.SOUTH);
		this.add(mainPanel,BorderLayout.CENTER);
		this.setVisible(true);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
