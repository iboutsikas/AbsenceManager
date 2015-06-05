package us.absencemanager.ui.dragonstoneui;

import java.util.EventListener;

import us.absencemanager.exceptions.NoDataFoundException;

public interface PopupListener extends EventListener {
	public void deleteStudentEvent(String studentId) throws NoDataFoundException;
	public void displayAbsencesEvent(String studentId) throws NoDataFoundException;
}
