package us.absencemanager.ui.nikos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddStudent extends JPanel {
	private JPanel mainPanel,contPanel,btPanel,stPanel;
	private JTextField idTf,fnTf,lnTf,eTf;
	private JLabel idLb,fnLb,lnLb,eLb,titlePanel;
	private JButton bCancel,bAdd;
	public AddStudent(){
		super(new BorderLayout());
		
		mainPanel=new JPanel(new BorderLayout());
		contPanel=new JPanel(new BorderLayout());
		btPanel=new JPanel(new GridLayout(0,2));
		stPanel=new JPanel(new GridLayout(4,4));
		
		idTf=new JTextField();
		fnTf=new JTextField();
		lnTf=new JTextField();
		eTf=new JTextField();
		
		idLb=new JLabel("ID:");
		fnLb=new JLabel("First name:");
		lnLb=new JLabel("Last name:");
		eLb=new JLabel("Email:");
		titlePanel=new JLabel("Add Student");
		
		bCancel=new JButton("Cancel");
		bAdd=new JButton("Add");
		
		stPanel.add(idLb);
		stPanel.add(idTf);
		stPanel.add(fnLb);
		stPanel.add(fnTf);
		stPanel.add(lnLb);
		stPanel.add(lnTf);
		stPanel.add(eLb);
		stPanel.add(eTf);
		
		btPanel.add(bCancel);
		btPanel.add(bAdd);
		
		bAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//while(!(fnTf == null)){
					String firstname=fnTf.getText();
					fnTf.setText("");
				//}
			}
		});
		
		contPanel.add(stPanel,BorderLayout.CENTER);
		contPanel.add(btPanel,BorderLayout.SOUTH);
		mainPanel.add(contPanel,BorderLayout.CENTER);
		mainPanel.add(titlePanel,BorderLayout.NORTH);
		this.add(mainPanel,BorderLayout.CENTER);
		
		
	}

}
