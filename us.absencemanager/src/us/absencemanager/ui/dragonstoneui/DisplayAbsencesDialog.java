package us.absencemanager.ui.dragonstoneui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import us.absencemanager.controller.Controller;
import us.absencemanager.exceptions.NoDataFoundException;
import us.absencemanager.model.Absence;

public class DisplayAbsencesDialog extends JDialog {
	private Controller c;
	private JTree absenceTree;
	private Map<String, ArrayList<Absence>> absences;
	private JButton closeButton;
	private JPanel buttonPanel;
	
	public DisplayAbsencesDialog(Window parent, String studentId) {
		super(parent, "Absences details", ModalityType.APPLICATION_MODAL);
		c = Controller.getInstance();
		
		try {
			absences = c.getStudentAbsences(studentId);
		} catch (NoDataFoundException e) {
			e.printStackTrace();
		}
		absenceTree = new JTree(createTree());
		closeButton = new JButton("OK");
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonPanel = new JPanel(new FlowLayout());
		setLayout(new BorderLayout());
		buttonPanel.add(closeButton);
		
		add(new JScrollPane(absenceTree), BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		setPreferredSize(new Dimension(400, 250));
		pack();
		setLocationRelativeTo(parent);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	private DefaultMutableTreeNode createTree() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Absences");
		
		for(String key: absences.keySet()) {
			DefaultMutableTreeNode branch = new DefaultMutableTreeNode(key);
			for(Absence a: absences.get(key)) {
				DefaultMutableTreeNode absence = new DefaultMutableTreeNode(a);
				branch.add(absence);
			}
			root.add(branch);
		}
		
		return root;
	}
}
