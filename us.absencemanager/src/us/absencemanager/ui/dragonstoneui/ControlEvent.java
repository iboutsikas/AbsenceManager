<<<<<<< HEAD
package us.absencemanager.ui.dragonstoneui;

import java.util.EventObject;

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
=======
package us.absencemanager.ui.dragonstoneui;

import java.util.EventObject;

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
>>>>>>> refs/heads/devB
