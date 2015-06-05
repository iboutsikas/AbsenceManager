package us.absencemanager.ui.dragonstoneui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;


public class TablePanel extends JScrollPane {
	private JTable table;
	private StudentTableModel model;
	private PopupMenu popup;
	
	public TablePanel() {
		table = new JTable();
		setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			/* (non-Javadoc)
			 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
			 */
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3) {
					int row = table.rowAtPoint(e.getPoint());
					table.getSelectionModel().setSelectionInterval(row, row);
					popup = new PopupMenu();
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
}
