package us.absencemanager.ui.dragonstoneui;

import java.util.EventObject;
/**
 * 
 * @author Ioannis Boutsikas
 *
 */
public class ControlEvent extends EventObject {

	private int groupId;
	
	public ControlEvent(Object source) {
		super(source);
	}
	
	public ControlEvent(Object source, int gId) {
		super(source);
		this.groupId = gId;
	}
	
	/**
	 * @return the groupId
	 */
	public int getGroupId() {
		return groupId;
	}
}
