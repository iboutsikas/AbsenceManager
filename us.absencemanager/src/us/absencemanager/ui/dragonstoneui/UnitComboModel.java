package us.absencemanager.ui.dragonstoneui;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import us.absencemanager.exceptions.InvalidOperationsException;
import us.absencemanager.model.Unit;

/**
 * 
 * @author Ioannis Boutsikas
 *
 */
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
		fireContentsChanged(this, 0, getSize());
	}
	
	public String getSelectedId() throws InvalidOperationsException {
		if (selection == null) {
			throw new InvalidOperationsException("You need to have at least one unit first");
		}
		return selection.getId();
	}
}
