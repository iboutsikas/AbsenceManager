package us.absencemanager.ui.dragonstoneui;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import us.absencemanager.model.Unit;

public class UnitComboModel extends AbstractListModel implements ComboBoxModel {
	List<Unit> list;
	Unit selection;
	
	@Override
	public Object getElementAt(int index) {
		return list.get(index);
	}

	@Override
	public int getSize() {
		return list.size();
	}

	@Override
	public Object getSelectedItem() {
		return selection;
	}

	@Override
	public void setSelectedItem(Object item) {
		selection = (Unit)item;
	}
	
	public void setData(List list) {
		this.list = list;
	}
	
	public String getSelectedId() {
		return selection.getId();
	}
}
