package us.absencemanager.ui.an;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import us.absencemanager.model.Student;

/**
 * @authors Athanasios Doulgeris , Nikolaos Doumpalas
 *
 */
public class AbsenceTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1410788068224646805L;
	private List<Student> list;
	private String[] columnNames = new String[]{"ID", "First Name", "Last Name", " Is Present"};
	private List<Boolean> boolList;

	
	@Override
	public Class<?> getColumnClass(int arg0) {
		if(arg0 == 3){
			return Boolean.class;
		}
		return super.getColumnClass(arg0);
	}


	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}


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
		return list.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Student s = list.get(row);
		Boolean b = boolList.get(row);
		switch(col) {
			case 0: 
				return s.getId();
			case 1:
				return s.getFirstName();
			case 2:
				return s.getLastName();
			case 3:
				return b.booleanValue();			
		}
		return null;
	}
	
	@Override
	public void setValueAt(Object aValue, int row, int col) {
		Student s = list.get(row);
		switch(col) {
			case 1:
				s.setFirstName((String)aValue);
			case 2:
				s.setLastName((String)aValue);		
			case 3:
				boolList.add(row,(Boolean) aValue);
		}
		fireTableCellUpdated(row, col);
	}
	
	public void setData(List<Student> list) {
		this.list = list;
		this.boolList = new ArrayList<Boolean>();
		for(int i = 0; i < this.list.size(); i++){
			boolList.add(i, false);
		}
	}
	
	

}