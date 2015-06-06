package us.absencemanager.ui.dragonstoneui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import us.absencemanager.exceptions.NoDataFoundException;
import us.absencemanager.model.Student;

/**
 * 
 * @author Ioannis Boutsikas
 *
 */
public class TablePanel extends JScrollPane {
	private JTable table;
	private StudentTableModel model;
	private JPopupMenu popup;
	private PopupListener listener;
	private JMenuItem deleteStudent;
	private JMenuItem displayAbsences;
	
	public TablePanel() {
		table = new JTable();
		setViewportView(table);
		popup = new JPopupMenu();
		deleteStudent = new JMenuItem("Delete student");
		displayAbsences = new JMenuItem("Display absences...");
		
		deleteStudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String id = (String) table.getValueAt(row, 0);
				try {
					listener.deleteStudentEvent(id);
				} catch (NoDataFoundException e1) {
					JOptionPane.showMessageDialog(TablePanel.this, "There was an error while deleting this student", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		displayAbsences.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String id = (String) table.getValueAt(row, 0);
				try {
					listener.displayAbsencesEvent(id);
				} catch (NoDataFoundException e1) {
					JOptionPane.showMessageDialog(TablePanel.this, "There was an error while displaying the absences this student", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		popup.add(deleteStudent);
		popup.add(displayAbsences);
		table.addMouseListener(new MouseAdapter() {
			/* (non-Javadoc)
			 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
			 */
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3) {
					int row = table.rowAtPoint(e.getPoint());
					table.getSelectionModel().setSelectionInterval(row, row);
					popup.show(table, e.getX(), e.getY());
				}
			}
		});
		
	}
	public void initModel() {
		model = new StudentTableModel();
		table.setModel(model);
	}
	public void setData(List list) {
		model.setData(list);
	}
	
	public void refresh() {
		model.addBoolean();
		model.fireTableDataChanged();
	}
	
	public void refresh(int row) {
		model.removeBoolean(row);
		model.fireTableDataChanged();
	}
	public String getSelectedStudent() throws IllegalStateException {
		try {
			return model.getValueAt(table.getSelectedRow(), 0).toString();
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalStateException("You should select a student from the table first");
		}
	}
	
	public void setModelListener(AdditionListener listener) {
		model.setModelListener(listener);
	}
	
	 public int getSelectedRow() {
		return table.getSelectedRow();
	}
	
	public void addPopupListener(PopupListener listener) {
		this.listener = listener;
	}
	
	public void resetBooleans() {
		model.resetBooleans();
	}
}
