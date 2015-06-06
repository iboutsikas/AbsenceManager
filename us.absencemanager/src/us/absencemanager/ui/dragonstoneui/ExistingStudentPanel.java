package us.absencemanager.ui.dragonstoneui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import us.absencemanager.exceptions.NoDataFoundException;
import us.absencemanager.model.Student;
/**
 * 
 * @author Ioannis Boutsikas
 *
 */
public class ExistingStudentPanel extends JPanel {
	private JList studentList;
	private DefaultListModel model;
	private JButton addToGroupButton;
	private JButton removeFromGroupButton;
	private JButton newStudentButton;
	private JPanel buttonPanel;
	private JScrollPane listPane;
	private AdditionListener listener;	
	private JPopupMenu popup;
	private PopupListener popupListener;
	private JMenuItem deleteStudent;
	private JMenuItem displayAbsences;
	
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
		popup = new JPopupMenu();
		deleteStudent = new JMenuItem("Delete student");
		displayAbsences = new JMenuItem("Display absences...");
		popup.add(deleteStudent);
		popup.add(displayAbsences);
		
		deleteStudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Student s = (Student) studentList.getSelectedValue();
				try {
					popupListener.deleteStudentEvent(s.getId());
				} catch (NoDataFoundException e1) {
					JOptionPane.showMessageDialog(ExistingStudentPanel.this, "There was an error while deleting this student", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(ExistingStudentPanel.this, "There are no students loaded", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		displayAbsences.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Student s = (Student) studentList.getSelectedValue();
				try {
					popupListener.displayAbsencesEvent(s.getId());
				} catch (NoDataFoundException e1) {
					JOptionPane.showMessageDialog(ExistingStudentPanel.this, "There was an error while displaying the absences this student", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(ExistingStudentPanel.this, "There are no students loaded", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		studentList.addMouseListener(new MouseAdapter() {
			/* (non-Javadoc)
			 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
			 */
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3) {
					int selection = studentList.locationToIndex(e.getPoint());
					studentList.setSelectedIndex(selection);
					popup.show(studentList, e.getX(), e.getY());
				}
			}
		});
		addToGroupButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Student s = (Student)model.getElementAt(studentList.getSelectedIndex());
					listener.moveToGroupEvent(s.getId());
				} catch (ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(ExistingStudentPanel.this), "Select a student from the list first", "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		removeFromGroupButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.removeFromGroupEvent();
			}
		});
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
		
		Border titledBorder = BorderFactory.createTitledBorder("Existing Students");
		Border spaceBorder = BorderFactory.createEmptyBorder(3, 10, 5, 10);
		setBorder(BorderFactory.createCompoundBorder(spaceBorder, titledBorder));
	}
	
	public void populateList(List<Student> allStudents, List<Student> groupStudents) {
		List<Student> temp = new ArrayList<Student>(allStudents);
		temp.removeAll(groupStudents);
		model.clear();
		for(Student s: temp) {
			model.addElement(s);
		}
	}
	
	public void populateList(List<Student> list) {
		model.clear();
		for (Student s: list) {
			model.addElement(s);
		}
	}
	public void setAdditionListener(AdditionListener listener) {
		this.listener = listener;				
	}
	
	public void setPopupListener(PopupListener listener) {
		this.popupListener = listener;
	}
}
