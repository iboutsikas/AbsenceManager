package us.absencemanager.ui.dragonstoneui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.text.DateFormatter;

import us.absencemanager.exceptions.InvalidOperationsException;
/**
 * 
 * @author Ioannis Boutsikas
 *
 */
@SuppressWarnings({"serial","rawtypes"})
public class ControlPanel extends JPanel {
	private JComboBox groupSelectionBox;
	private JLabel groupSelectionLabel;
	private JComboBox unitSelectionBox;
	private JLabel unitSelectionLabel;
	private JLabel classroomLabel;
	private JTextField classroomText;
	private JSpinner dateSpinner;
	private JLabel dateLabel;
	private JSpinner timeSpinner;
	private JLabel timeLabel;
	private JButton loadButton;
	private ControlListener listener;
	private GroupComboModel groupModel;
	private UnitComboModel unitModel;
	private JButton deleteGroupButton;
	private JButton deleteUnitButton;
	
	
	public ControlPanel(List groupList, List unitList) {
		initializeComponents(groupList, unitList);
		layoutComponents();	
		loadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int gId = 0;
				try {
					gId = groupModel.getSelectedId();
				} catch (InvalidOperationsException e1) {
					JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(ControlPanel.this), e1.getMessage(), "Error",JOptionPane.WARNING_MESSAGE);
				}
				ControlEvent ce = new ControlEvent(this, gId);
				listener.loadEvent(ce);
			}
		});
		unitSelectionBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				int gId = 0;
				try {
					gId = groupModel.getSelectedId();
				} catch (InvalidOperationsException e1) {
					JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(ControlPanel.this), e1.getMessage(), "Error",JOptionPane.WARNING_MESSAGE);
				}
				ControlEvent ce = new ControlEvent(this, gId);
				listener.loadEvent(ce);
			}
		});
		groupSelectionBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				int gId = 0;
				try {
					gId = groupModel.getSelectedId();
				} catch (InvalidOperationsException e1) {
					JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(ControlPanel.this), e1.getMessage(), "Error",JOptionPane.WARNING_MESSAGE);
				}
				ControlEvent ce = new ControlEvent(this, gId);
				listener.loadEvent(ce);
			}
		});
		deleteGroupButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int gId = 0;
				try {
					gId = groupModel.getSelectedId();
				} catch (InvalidOperationsException e1) {
					JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(ControlPanel.this), e1.getMessage(), "Error",JOptionPane.WARNING_MESSAGE);
				}
				listener.deleteGroupEvent(gId);
			}
		});
		deleteUnitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String uId = "";
				try {
					uId = unitModel.getSelectedId();
				} catch (InvalidOperationsException e1) {
					JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(ControlPanel.this), e1.getMessage(), "Error",JOptionPane.WARNING_MESSAGE);
				}
				listener.deleteUnitEvent(uId);
			}
		});
	}
	
	private void layoutComponents() {
		setLayout(new GridBagLayout());
		Border titledBorder = BorderFactory.createTitledBorder("Controls");
		Border spaceBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		setBorder(BorderFactory.createCompoundBorder(spaceBorder, titledBorder));
		GridBagConstraints gc = new GridBagConstraints();
		Insets controlInset = new Insets(0, 10, 0, 10);
		Insets labelInset = new Insets(0, 10, 0, 0);
		///// First row ////
		gc.gridy = 0;
		gc.gridx = 0;
		gc.weightx = 1;
		gc.weighty = 0.02;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = labelInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(groupSelectionLabel, gc);
		
		gc.gridx = 1;
		gc.insets = controlInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(groupSelectionBox, gc);
		//// Next Row ////
		gc.gridy++;
		gc.gridx = 0;
		gc.insets = labelInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(unitSelectionLabel, gc);
		
		gc.gridx = 1;
		gc.insets = controlInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(unitSelectionBox, gc);
		//// Next Row ////
		gc.gridy++;
		gc.gridx = 0;
		gc.insets = labelInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(classroomLabel, gc);
		
		gc.gridx = 1;
		gc.insets = controlInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(classroomText, gc);
		//// Next Row ////
		gc.gridy++;
		gc.gridx = 0;
		gc.insets = labelInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(dateLabel, gc);
		
		gc.gridx = 1;
		gc.insets = controlInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(dateSpinner, gc);
		//// Next Row ////
		gc.gridy++;
		gc.gridx = 0;
		gc.insets = labelInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(timeLabel, gc);
			
		gc.gridx = 1;
		gc.insets = controlInset;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(timeSpinner, gc);
		//// Next Row ////
		gc.gridy++;
		gc.gridx = 0;
		gc.weighty = 0.08;
		gc.anchor = GridBagConstraints.LINE_START;
		add(loadButton, gc);
		
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		buttonPanel.add(deleteGroupButton);
		buttonPanel.add(deleteUnitButton);
		gc.gridx = 1;
		add(buttonPanel, gc);
	}
	
	@SuppressWarnings({ "unchecked" })
	private void initializeComponents(List groupList, List unitList) {
		//Initialize components
		groupModel = new GroupComboModel();
		groupModel.setData(groupList);
		groupSelectionBox = new JComboBox(groupModel);
		groupSelectionBox.setSelectedIndex(0);
		groupSelectionLabel = new JLabel("Select group:");
		unitModel = new UnitComboModel();
		unitModel.setData(unitList);
		unitSelectionBox = new JComboBox(unitModel);
		if(unitSelectionBox.getItemCount() != 0) {
			unitSelectionBox.setSelectedIndex(0);
		} else {
			unitSelectionBox.setSelectedIndex(-1);
		}
		unitSelectionLabel = new JLabel("Select unit:");
		classroomText = new JTextField(5);
		Dimension dim = classroomText.getPreferredSize();
		classroomText.setSize(dim);
		classroomText.setMinimumSize(dim);
		classroomLabel = new JLabel("Select classroom:");
		dateSpinner = new JSpinner();
		dateLabel = new JLabel("Select date:");
		timeSpinner = new JSpinner();
		timeLabel = new JLabel("Select time:");
		loadButton = new JButton("Load Students");
		deleteGroupButton = new JButton("Delete Group");
		deleteUnitButton = new JButton("Delete Unit");
		Dimension d = loadButton.getPreferredSize();
		deleteGroupButton.setPreferredSize(d);
		deleteUnitButton.setPreferredSize(d);
		
		
		
		
		//Setup time spinner
		Calendar calendar = Calendar.getInstance();
		SpinnerDateModel timeModel = new SpinnerDateModel();
		timeModel.setValue(calendar.getTime());
		timeSpinner.setModel(timeModel);
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH : mm");
		DateFormatter timeFormatter = (DateFormatter)timeEditor.getTextField().getFormatter();
		timeFormatter.setAllowsInvalid(false); // this makes what you want
		timeFormatter.setOverwriteMode(true);
		timeSpinner.setEditor(timeEditor);
		
		//Setup date spinner
		SpinnerDateModel dateModel = new SpinnerDateModel();
		dateModel.setValue(calendar.getTime());
		dateSpinner.setModel(dateModel);
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd / MM / yyyy");
		DateFormatter dateFormatter = (DateFormatter)dateEditor.getTextField().getFormatter();
		dateFormatter.setAllowsInvalid(false); // this makes what you want
		dateFormatter.setOverwriteMode(true);
		dateSpinner.setEditor(dateEditor);
	}
	
	public void setControlListener(ControlListener listener) {
		this.listener = listener;
	}
	
	public void refreshGroups(List groupList) {
		groupModel.setData(groupList);
	}
	
	public ControlPanelInfo getPanelInfo() {
		String date = new SimpleDateFormat("dd / MM / yyyy").format(dateSpinner.getValue());
		String time = new SimpleDateFormat("HH : mm").format(timeSpinner.getValue());
		String dateTime = date + " - " + time;
		String classroom = classroomText.getText();
		String uId = "";
		int gId = 0;
		try {
			gId = groupModel.getSelectedId();
			uId = unitModel.getSelectedId();
		} catch (InvalidOperationsException e1) {
			JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(ControlPanel.this), e1.getMessage(), "Error",JOptionPane.WARNING_MESSAGE);
		}
		return new ControlPanelInfo(gId, uId, dateTime , classroom);
	}

	public void refreshUnits(List unitList) {
		unitModel.setData(unitList);
	}
}
