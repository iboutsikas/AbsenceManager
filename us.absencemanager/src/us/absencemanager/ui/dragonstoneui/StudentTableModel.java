package us.absencemanager.ui.dragonstoneui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import us.absencemanager.model.Student;

public class StudentTableModel extends AbstractTableModel {
	private List<Student> list;
	private String[] columnNames = new String[]{"ID", "First Name", "Last Name", " Is Present"};
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

	@Override
	public int getColumnCount() {
		return 4;
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
				return false;			
		}
		return null;
	}
	
	
	public void setData(List<Student> list) {
		this.list = list;
	}
}
