package us.absencemanager.ui.dragonstoneui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import us.absencemanager.exceptions.InvalidOperationsException;
import us.absencemanager.model.StudentGroup;
/**
 * 
 * @author Ioannis Boutsikas
 *
 */
public class GroupComboModel extends AbstractListModel implements ComboBoxModel {
	List<StudentGroup> list;
	StudentGroup selection;
	
	public StudentGroup getElementAt(int index) {
		return list.get(index);
	}

	public int getSize() {
		return list.size();
	}

	@Override
	public Object getSelectedItem() {
		return selection;
	}

	@Override
	public void setSelectedItem(Object item) {
		selection = (StudentGroup)item;
	}

	public void setData(List list) {
		this.list = list;
		fireContentsChanged(this, 0, getSize());
	}
	
	public int getSelectedId() throws InvalidOperationsException {
		if (selection == null) {
			throw new InvalidOperationsException("You need to have at least one group first");
		}
		return selection.getID();
	}
}
