package us.absencemanager.ui.dragonstoneui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class NewUnitDialog extends JDialog {
	private JLabel idLabel;
	private JTextField idText;
	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel absLabel;
	private JSpinner absSpinner;
	private JButton addButton;
	private JButton cancelButton;
	private AdditionListener listener;
	
	public NewUnitDialog(Window parent) {
		super(parent, "Add Group", ModalityType.APPLICATION_MODAL);
		idLabel = new JLabel("Unit ID:");
		idText = new JTextField(15);
		nameLabel = new JLabel("Unit Name:");
		nameText = new JTextField(15);
		absLabel = new JLabel("Max absences:");
		absSpinner = new JSpinner();
		addButton = new JButton("Add");
		cancelButton = new JButton("Cancel");
		Dimension dim = cancelButton.getPreferredSize();
		addButton.setPreferredSize(dim);
		cancelButton.setPreferredSize(dim);
		layoutComponents();
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				String id = idText.getText();
				String name = nameText.getText();
				int abs = (int)absSpinner.getValue();
				UnitEvent ue = new UnitEvent(this, id, name, abs);
				listener.additionEventRaised(ue);
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				NewUnitDialog.this.dispose();
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
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = labelInset;
		add(nameLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = controlInset;
		add(nameText, gc);
		//// Next Row ////
		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = labelInset;
		add(absLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = controlInset;
		add(absSpinner, gc);
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
