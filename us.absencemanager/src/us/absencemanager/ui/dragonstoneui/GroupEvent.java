package us.absencemanager.ui.dragonstoneui;
/**
 * 
 * @author Ioannis Boutsikas
 *
 */
public class GroupEvent extends CustomEvent {
	String name;
	public GroupEvent(Object source) {
		super(source);
	}
	
	public GroupEvent(Object source, String name) {
		super(source);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
