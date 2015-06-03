package us.absencemanager.ui.ad;

import java.util.List;

import us.absencemanager.model.*;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class StudentTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6673551429521277461L;

	private List<Student> list;
	private String[] columnNames = new String[]{"ID", "First Name", "Last Name","Email","Absences"};
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Student s = list.get(row);
		switch(col) {
			case 0: 
				return s.getId();
			case 1:
				return s.getFirstName();
			case 2:
				return s.getLastName();		
			case 3:
				return s.getEmail();
			case 4:
				return 0;
		}
		return null;
	}

	public void setData(List<Student> list) {
		this.list = list;
	}



	
	
}
