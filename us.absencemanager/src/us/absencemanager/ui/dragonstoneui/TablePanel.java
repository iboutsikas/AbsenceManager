package us.absencemanager.ui.dragonstoneui;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;


public class TablePanel extends JScrollPane {
	private JTable table;
	private StudentTableModel model;
	
	public TablePanel() {
		table = new JTable();
		setViewportView(table);
	}
	public void initModel() {
		model = new StudentTableModel();
		table.setModel(model);
	}
	public void setData(List list) {
		model.setData(list);
	}
	
	public void refresh() {
		model.fireTableDataChanged();
	}
	
	public String getSelectedStudent() throws IllegalStateException {
		try {
			return model.getValueAt(table.getSelectedRow(), 0).toString();
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalStateException("You should select a student from the table first");
		}
	}
}
