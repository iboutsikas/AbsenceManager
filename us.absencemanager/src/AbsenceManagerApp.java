import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class AbsenceManagerApp {
	private static JFrame frame;
	public static void main(String[] args) {
		JFrame selectorFrame = new JFrame("Select GUI to launch");
		JRadioButton dgsButton = new JRadioButton("DragonstoneUI");
		JRadioButton msiButton = new JRadioButton("MousatoiUI");
		JButton launchButton = new JButton("Launch");
		ButtonGroup buttonGroup= new ButtonGroup();
		buttonGroup.add(dgsButton);
		buttonGroup.add(msiButton);
		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		radioPanel.add(dgsButton);
		radioPanel.add(msiButton);
		selectorFrame.add(radioPanel, BorderLayout.CENTER);
		selectorFrame.add(launchButton, BorderLayout.SOUTH);
		
		launchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(dgsButton.isSelected()) {
					frame = new us.absencemanager.ui.dragonstoneui.MainFrame();
					frame.pack();
					frame.setVisible(true);
					selectorFrame.dispose();
				} else if (msiButton.isSelected()) {
					frame = new us.absencemanager.ui.an.MainWindow();
					selectorFrame.dispose();
				}
			}
		});
		
		
		
		
		selectorFrame.setPreferredSize(new Dimension(280, 120));
		selectorFrame.pack();
		selectorFrame.setResizable(false);
		selectorFrame.setLocationRelativeTo(null);
		selectorFrame.setVisible(true);
	}

}
