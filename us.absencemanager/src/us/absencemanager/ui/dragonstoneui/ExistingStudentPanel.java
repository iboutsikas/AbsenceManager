package us.absencemanager.ui.dragonstoneui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import us.absencemanager.model.Student;

public class ExistingStudentPanel extends JPanel {
	private JList studentList;
	private DefaultListModel model;
	private JButton addToGroupButton;
	private JButton removeFromGroupButton;
	private JButton newStudentButton;
	private JPanel buttonPanel;
	private JScrollPane listPane;
	private AdditionListener listener;	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ExistingStudentPanel() {
		studentList = new JList();
		model = new DefaultListModel();
		studentList.setModel(model);
		studentList.setCellRenderer(new StudentListRenderer());
		listPane  = new JScrollPane();
		addToGroupButton = new JButton(">>");
		removeFromGroupButton = new JButton("<<");
		newStudentButton = new JButton("New...");
		Dimension dim = newStudentButton.getPreferredSize();
		addToGroupButton.setPreferredSize(dim);
		removeFromGroupButton.setPreferredSize(dim);
		buttonPanel = new JPanel(new GridLayout(3,1));
		
		newStudentButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NewStudentDialog nsd = new NewStudentDialog(SwingUtilities.getWindowAncestor(ExistingStudentPanel.this));
				nsd.setAdditionListener(listener);
				nsd.setVisible(true);
			}
		});
		
		setLayout(new BorderLayout());
		buttonPanel.add(addToGroupButton);
		buttonPanel.add(removeFromGroupButton);
		buttonPanel.add(newStudentButton);
		listPane.setViewportView(studentList);
		add(listPane, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.EAST);
		
		Border titledBorder = BorderFactory.createTitledBorder("Controls");
		Border spaceBorder = BorderFactory.createEmptyBorder(3, 10, 5, 10);
		setBorder(BorderFactory.createCompoundBorder(spaceBorder, titledBorder));
	}
	
	public void populateList(List<Student> list) {
		for(Student s: list) {
			model.addElement(s);
		}
	}
	public void setAdditionListener(AdditionListener listener) {
		this.listener = listener;				
	}
}
