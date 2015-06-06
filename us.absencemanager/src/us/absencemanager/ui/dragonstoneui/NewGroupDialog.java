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
/**
 * 
 * @author Ioannis Boutsikas
 *
 */
public class NewGroupDialog extends JDialog {
	private JLabel nameLabel;
	private JTextField nameText;
	private JButton addButton;
	private JButton cancelButton;
	private AdditionListener listener;
	
	public NewGroupDialog(Window parent) {
		super(parent, "Add Group", ModalityType.APPLICATION_MODAL);
		nameLabel = new JLabel("Group's name:");
		nameText = new JTextField(15);
		addButton = new JButton("Add");
		cancelButton = new JButton("Cancel");
		Dimension dim = cancelButton.getPreferredSize();
		addButton.setPreferredSize(dim);
		cancelButton.setPreferredSize(dim);
		layoutComponents();
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				String name = nameText.getText();
				
				GroupEvent ge = new GroupEvent(this, name);
				listener.additionEventRaised(ge);
				NewGroupDialog.this.dispose();
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				NewGroupDialog.this.dispose();
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
		add(nameLabel, gc);
		
		gc.gridx = 1;
		gc.insets = controlInset;
		add(nameText, gc);
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
