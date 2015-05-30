package us.absencemanager.ui.dragonstoneui;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;


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
}
