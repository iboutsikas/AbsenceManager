package us.absencemanager.ui.dragonstoneui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import us.absencemanager.controller.Controller;
import us.absencemanager.exceptions.NoDataFoundException;
import us.absencemanager.model.Absence;
import us.absencemanager.model.Unit;

public class DisplayAbsencesDialog extends JDialog {
	private Controller c;
	private JTree absenceTree;
	private Map<String, ArrayList<Absence>> absences;
	private List<Unit> units;
	private JButton closeButton;
	private JPanel buttonPanel;
	
	public DisplayAbsencesDialog(Window parent, String studentId) {
		super(parent, "Absences details", ModalityType.APPLICATION_MODAL);
		c = Controller.getInstance();
		
		try {
			absences = c.getStudentAbsences(studentId);
			units = c.getUnits();
		} catch (NoDataFoundException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
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
			try {
				Unit u = getUnitById(key);
				int currentAbs = absences.get(key).size();
				branch = new DefaultMutableTreeNode(key + " - " + u.getName() + "  ("+currentAbs+"/"+u.getMaxAbsences()+")");
			} catch (NoDataFoundException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
			}
			for(Absence a: absences.get(key)) {
				DefaultMutableTreeNode absence = new DefaultMutableTreeNode(a);
				branch.add(absence);
			}
			root.add(branch);
		}
		
		return root;
	}
	
	private Unit getUnitById(String id) throws NoDataFoundException {
		List<Unit> value = units.stream().filter(u -> u.getId().equals(id))
								   .collect(Collectors.toList());
		if(value.size() != 1) {
			throw new NoDataFoundException("Could not find Unit, with id:" + id);
		}
		return value.get(0);
	}
}
