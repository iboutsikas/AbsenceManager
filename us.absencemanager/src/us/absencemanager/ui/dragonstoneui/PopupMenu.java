package us.absencemanager.ui.dragonstoneui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopupMenu extends JPopupMenu {
	private JMenuItem deleteStudent;
	private JMenuItem displayAbsences;
	
	public PopupMenu () {
		deleteStudent = new JMenuItem("Delete student");
		displayAbsences = new JMenuItem("Display absences...");
		deleteStudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		add(deleteStudent);
		add(displayAbsences);
	}
}
