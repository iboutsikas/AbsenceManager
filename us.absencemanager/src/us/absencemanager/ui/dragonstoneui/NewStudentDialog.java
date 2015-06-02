package us.absencemanager.ui.dragonstoneui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewStudentDialog extends JDialog {
	private JLabel idLabel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel emailLabel;
	private JTextField idText;
	private JTextField firstNameText;
	private JTextField lastNameText;
	private JTextField emailText;
	private JCheckBox groupCheckBox;
	private JButton addButton;
	private JButton cancelButton;
	private AdditionListener listener;
	
	public NewStudentDialog(Window parent) {
		super(parent, "Add Student", ModalityType.APPLICATION_MODAL);
		idLabel = new JLabel("ID:");
		firstNameLabel = new JLabel("First Name:");
		lastNameLabel = new JLabel("Last Name:");
		emailLabel = new JLabel("email:");
		idText = new JTextField(8);
		firstNameText = new JTextField(8);
		lastNameText = new JTextField(8);
		emailText = new JTextField(8);
		groupCheckBox = new JCheckBox("Add to current group", true);
		addButton = new JButton("Add");
		cancelButton = new JButton("Cancel");
		Dimension dim = cancelButton.getPreferredSize();
		addButton.setPreferredSize(dim);
		cancelButton.setPreferredSize(dim);
		layoutComponents();
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				String id = idText.getText();
				String fName = firstNameText.getText();
				String lName = lastNameText.getText();
				String email = emailText.getText();
				Boolean add = groupCheckBox.isSelected();
				
				StudentEvent se = new StudentEvent(this, id, fName, lName, email, add);
				listener.additionEventRaised(se);
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				NewStudentDialog.this.dispose();
			}
		});
		
		pack();
		setLocationRelativeTo(parent);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void setAdditionListener(AdditionListener listener) {
		this.listener = listener;				
	}
	
	private void layoutComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		Insets controlInset = new Insets(3, 5, 0, 3);
		Insets labelInset = new Insets(3, 3, 0, 5);
		//// First Row ////
		gc.gridy = 0;
		gc.gridx = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = labelInset;
		add(idLabel, gc);
		
		gc.gridx = 1;
		gc.insets = controlInset;
		add(idText, gc);
		//// Next Row ////
		gc.gridy++;
		gc.gridx = 0;
		gc.insets = labelInset;
		add(firstNameLabel, gc);
		
		gc.gridx = 1;
		gc.insets = controlInset;
		add(firstNameText, gc);
		//// Next Row ////
		gc.gridy++;
		gc.gridx = 0;
		gc.insets = labelInset;
		add(lastNameLabel, gc);
		
		gc.gridx = 1;
		gc.insets = controlInset;
		add(lastNameText, gc);
		//// Next Row ////
		gc.gridy++;
		gc.gridx = 0;
		gc.insets = labelInset;
		add(emailLabel, gc);
		
		gc.gridx = 1;
		gc.insets = controlInset;
		add(emailText, gc);
		//// Next Row ////
		gc.gridy++;
		gc.gridx = 0;
		gc.insets = labelInset;
		add(groupCheckBox, gc);
		//// Next Row ////
		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = labelInset;
		add(addButton, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = controlInset;
		add(cancelButton, gc);
	}
	
}
