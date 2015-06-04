package us.absencemanager.ui.nikos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class EditGroupOfStudents extends JPanel{
	private JTable table;
	private JPanel contPanel,titlePanel,titleContPanel,contTitlePanel,rnPanel,btPanel;
	private JComboBox chsGrCb;
	private JLabel grLb,nmLb,titleofPanel;
	private JTextField rnTf;
	private JButton bRename,bCancel,bSave,bDelete;
	private boolean DEBUG = false;
	public EditGroupOfStudents(){
		super(new BorderLayout());
		
		table=new JTable(new StudentView());
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        
      //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        
        contPanel=new JPanel(new BorderLayout());
        titlePanel=new JPanel(new GridLayout(0,2));
        titleContPanel=new JPanel(new GridLayout(0,2));
        contTitlePanel=new JPanel(new BorderLayout());
        rnPanel=new JPanel(new GridLayout(0,3));
        
        chsGrCb=new JComboBox();
        
        grLb =new JLabel("Group:");
        
        nmLb=new JLabel("New name:");
        
        titleofPanel=new JLabel("Edit group of students");
        
        titlePanel.add(titleofPanel);
        
        titleContPanel.add(grLb);
        titleContPanel.add(chsGrCb);
        titlePanel.add(titleContPanel);
        
        rnTf=new JTextField();
        bRename=new JButton("Rename");
        
        rnPanel.add(nmLb);
        rnPanel.add(rnTf);
        rnPanel.add(bRename);
        
        contTitlePanel.add(titlePanel,BorderLayout.NORTH);
        contTitlePanel.add(rnPanel,BorderLayout.CENTER);
        
        contPanel.add(contTitlePanel,BorderLayout.NORTH);
        contPanel.add(scrollPane,BorderLayout.CENTER);
        
        btPanel=new JPanel(new GridLayout(0,3));
        
        bCancel=new JButton("Cancel");
        bSave=new JButton("Save");
        bDelete=new JButton("Remove group");
        
        btPanel.add(bCancel);
        btPanel.add(bSave);
        btPanel.add(bDelete);
        
        bDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int row=table.getRowCount();
				table.removeRowSelectionInterval(row,row-1);
				//thisFrame.pack();
				
			}
		});
       
        contPanel.add(btPanel,BorderLayout.SOUTH);
        this.add(contPanel,BorderLayout.CENTER);
        
        
        
        
        
	}
	class StudentView extends AbstractTableModel{
		private String []columnNames={"ID","Name","Number of members"};
		private Object [][]data={{new Integer(4),"Smith",new Integer(10)}};

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
