package us.absencemanager.ui.dragonstoneui;

import java.util.EventListener;

public interface AdditionListener extends EventListener {
	public void additionEventRaised(CustomEvent ev);
	public void saveEventRaised();
	public void moveToGroupEvent(String studentId);
	public void removeFromGroupEvent();
}
