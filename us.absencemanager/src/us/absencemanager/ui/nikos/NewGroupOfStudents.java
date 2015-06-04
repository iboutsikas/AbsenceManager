package us.absencemanager.ui.nikos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class NewGroupOfStudents extends JPanel{
	private JTable table;
	private JPanel contPanel,titlePanel,titleContPanel,btPanel;
	private JLabel titleofPanel,grOfSt,nLb;
	private JComboBox chGrCb;
	private JTextField nTf;
	private JButton bCreate,bCancel,bSave;
	private boolean DEBUG = false;
	public NewGroupOfStudents(){
		super(new BorderLayout());
		
		table=new JTable(new StudentView());
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        
      //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        titlePanel=new JPanel(new GridLayout(0,2));
        titleofPanel=new JLabel("New group of students");
        titleContPanel=new JPanel(new GridLayout(0,3));
        btPanel=new JPanel(new GridLayout(0,2));
        bCancel=new JButton("Cancel");
        bSave=new JButton("Save");
        nTf=new JTextField();
        nLb=new JLabel("Name:");
        bCreate=new JButton("Create");
        titlePanel.add(titleofPanel);
        titleContPanel.add(nLb);
        titleContPanel.add(nTf);
        titleContPanel.add(bCreate);
        titlePanel.add(titleContPanel);
        btPanel.add(bCancel);
        btPanel.add(bSave);
        
        contPanel=new JPanel(new BorderLayout());
        
       
        //Add the scroll pane to this panel.
        contPanel.add(scrollPane,BorderLayout.CENTER);
        contPanel.add(titlePanel,BorderLayout.NORTH);
        contPanel.add(btPanel,BorderLayout.SOUTH);
        this.add(contPanel,BorderLayout.CENTER);
        
        
        
        
        
	}
	class StudentView extends AbstractTableModel{
		private String []columnNames={"ID","First name","Last name","Email","In Group?"};
		private Object [][]data={{new Integer(5),"Smith","Snowboarding","papaki@gmail.com",new Boolean(true)}};

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
		public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
		public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col == 4) {
                return true;
            } else {
                return false;
            }
        }
		public void setValueAt(Object value, int row,int col) {
			data[row][col] = value;
	        fireTableCellUpdated(row, col);
	        printDebugData();
			
		}
		private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();
		}
		
	}

}
