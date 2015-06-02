package us.absencemanager.ui.dragonstoneui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	private JMenu fileMenu;
	private JMenu newMenu;
	private JMenuItem studentMenuItem;
	private JMenuItem groupMenuItem;
	private JMenuItem unitMenuItem;
	private JMenuItem exitMenuItem;
	private AdditionListener listener;
	
	
	public MenuBar() {
		fileMenu = new JMenu("File");
		exitMenuItem = new JMenuItem("Exit");
		fileMenu.add(exitMenuItem);
		
		newMenu = new JMenu("New");
		studentMenuItem = new JMenuItem("Student...");
		groupMenuItem = new JMenuItem("Student Group...");
		unitMenuItem = new JMenuItem("Unit...");
		newMenu.add(studentMenuItem);
		newMenu.add(groupMenuItem);
		newMenu.add(unitMenuItem);
		
		
		add(fileMenu);
		add(newMenu);
		
		studentMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NewStudentDialog nsd = new NewStudentDialog(SwingUtilities.getWindowAncestor(MenuBar.this));
				nsd.setAdditionListener(listener);
				nsd.setVisible(true);
			}
		});
		groupMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NewGroupDialog ngd = new NewGroupDialog(SwingUtilities.getWindowAncestor(MenuBar.this));
				ngd.setAdditionListener(listener);
				ngd.setVisible(true);
			}
		});
		unitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NewUnitDialog nud = new NewUnitDialog(SwingUtilities.getWindowAncestor(MenuBar.this));
				nud.setAdditionListener(listener);
				nud.setVisible(true);
			}
		});
	}
	
	public void setAdditionListener(AdditionListener listener) {
		this.listener = listener;				
	}
}
