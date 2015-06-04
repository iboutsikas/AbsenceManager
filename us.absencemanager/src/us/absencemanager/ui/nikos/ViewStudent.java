package us.absencemanager.ui.nikos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class ViewStudent extends JPanel{
	private JTable table;
	private JPanel contPanel,titlePanel;
	private JLabel titleofPanel,grOfSt;
	private JComboBox chGrCb;
	public ViewStudent(){
		super(new BorderLayout());
		
		table=new JTable(new StudentView());
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        
      //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        titlePanel=new JPanel(new GridLayout(0,3));
        titleofPanel=new JLabel("View student");
        grOfSt=new JLabel("Group of students:");
        chGrCb=new JComboBox();
        titlePanel.add(titleofPanel);
        titlePanel.add(grOfSt);
        titlePanel.add(chGrCb);
        contPanel=new JPanel(new BorderLayout());
        //Add the scroll pane to this panel.
        contPanel.add(scrollPane,BorderLayout.CENTER);
        contPanel.add(titlePanel,BorderLayout.NORTH);
        this.add(contPanel,BorderLayout.CENTER);
        
        
        
        
        
	}
	class StudentView extends AbstractTableModel{
		private String []columnNames={"ID","First name","Last name","Email"};
		private String [][]data={{"5","Smith","Snowboarding","papaki@gmail.com"}};

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			 return columnNames.length;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			 return data.length;
		}
		public String getColumnName(int col) {
            return columnNames[col];
        }

		@Override
		public Object getValueAt(int row, int col) {
            return data[row][col];
        }
	        
		
	}

}
