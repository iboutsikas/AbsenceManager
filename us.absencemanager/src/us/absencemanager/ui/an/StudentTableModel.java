package us.absencemanager.ui.an;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import us.absencemanager.model.*;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class StudentTableModel extends AbstractTableModel{
	private List<Student> list;
	private TreeMap<String, Integer> map;
	private String[] columnNames = new String[]{"ID", "First Name", "Last Name","Absences", "Select"};
	private List<Boolean> boolList;

	
	@Override
	public Class<?> getColumnClass(int arg0) {
		if(arg0 == 4){
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
			case 4:
				return true;
			default:
				return false;
		}
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
		Boolean b = boolList.get(row);
		switch(col) {
			case 0: 
				return s.getId();
			case 1:
				return s.getFirstName();
			case 2:
				return s.getLastName();
			case 3:
				return map.get(s.getId());			
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
				map.put(list.get(row).getId(), (Integer) aValue);
			case 4:
				boolList.add(row,(Boolean) aValue);
		}
		fireTableCellUpdated(row, col);
	}
	
	public void setData(List<Student> list, TreeMap<String, Integer> map) {
		this.list = list;
		this.map = new TreeMap<String, Integer>();
		this.map = map;
		this.boolList = new ArrayList<Boolean>();
		
		for(int i = 0; i < this.list.size(); i++){
			boolList.add(i, false);
		}
	}
	
}
