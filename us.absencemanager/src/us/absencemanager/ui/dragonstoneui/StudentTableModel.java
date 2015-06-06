package us.absencemanager.ui.dragonstoneui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import us.absencemanager.model.Student;
/**
 * 
 * @author Ioannis Boutsikas
 *
 */
public class StudentTableModel extends AbstractTableModel {
	private List<Student> list;
	private List<Boolean> bools;
	private String[] columnNames = new String[]{"ID", "First Name", "Last Name", " Is Absent"};
	private AdditionListener listener;
	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
	 */
	@Override
	public Class<?> getColumnClass(int col) {
		switch(col) {
			case 3:
				return Boolean.class;
			default:
				return String.class;
		}
	}
	

	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int arg0) {
		return columnNames[arg0];
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int row, int column) {
		switch (column)
		{
			case 3:
				return true;
			default:
				return false;
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#setValueAt(java.lang.Object, int, int)
	 */
	@Override
	public void setValueAt(Object inValue, int row, int col) {
		boolean value = (Boolean)inValue;
		String id = getValueAt(row, 0).toString();
		switch(col) {
			case 3:
				bools.add(row, value);
				if(value) {
					listener.addAbsenceEvent(id);
				} else {
					listener.removeAbsenceEvent(id);
				}
				
		}
		fireTableCellUpdated(row, col);
	}


	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		try{
			return list.size();
		} catch (Exception e) {
			return 0;
		}
		
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
				return bools.get(row);			
		}
		return null;
	}
	
	
	public void setData(List<Student> list) {
		this.list = list;
		this.bools = new ArrayList<Boolean>();
		for (Student s: list) {
			bools.add(false);
		}
	}
	
	public void addBoolean() {
		bools.add(false);
	}
	
	public void setModelListener(AdditionListener listener) {
		this.listener = listener;
	}
	
	public void removeBoolean(int row) {
		bools.remove(row);
	}


	public void resetBooleans() {
		bools.clear();
		for(Student s: list) {
			
		}
	}
}
