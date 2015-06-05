package us.absencemanager.ui.dragonstoneui;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopupMenu extends JPopupMenu {
	private JMenuItem deleteStudent;
	private JMenuItem displayAbsences;
	
	public PopupMenu () {
		deleteStudent = new JMenuItem("Delete student");
		displayAbsences = new JMenuItem("Display absences...");
		
		add(deleteStudent);
		add(displayAbsences);
	}
}
