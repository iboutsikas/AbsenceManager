package us.absencemanager.ui.dragonstoneui;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import us.absencemanager.model.Student;

@SuppressWarnings("rawtypes")
public class StudentListRenderer implements ListCellRenderer {
	private JPanel panel;
	private JLabel label;
	private Color selectedColor;
	private Color defaultColor;
	
	public StudentListRenderer() {
		panel = new JPanel();
		label = new JLabel();
		selectedColor = new Color(222, 71, 150);
		defaultColor = Color.WHITE;
		
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(label);
	}
	

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		Student s = (Student)value;
		panel.setBackground(isSelected ? selectedColor: defaultColor);
		label.setText(s.getId() + " - " + s.getLastName() + " " + s.getFirstName());
		return panel;
	}

}
