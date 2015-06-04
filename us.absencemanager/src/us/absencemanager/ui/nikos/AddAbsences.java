package us.absencemanager.ui.nikos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class AddAbsences extends JPanel {
	private JTable table;
	private JLabel titlePanel,groupCb,timeCb,hCb,sCb;
	private JPanel contPanel,frScrPanel,mainPanel,frScrContPanel,btPanel,tContPanel,tMainPanel,btTPanel;
	private JButton bNext,bCancel,bSave,btSave,btCancel;
	private JComboBox chgCb,chtHCb,chtSCb;
	private String []hours={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
	private String []seconds={"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"};
	
	private JFrame mainFrameS,thisFrame;
	//private AddAbsences thisFrame;
	
	MainFrame mainFrame;
	public AddAbsences(JFrame fr){
		super(new BorderLayout());
		thisFrame = fr;
		titlePanel = new JLabel("Add Absences");
		groupCb = new JLabel("Group of students:");
		timeCb=new JLabel("Time:");
		hCb =new JLabel("Hour");
		sCb=new JLabel("Second");
		
		
		contPanel=new JPanel();
		frScrPanel=new JPanel();
		frScrPanel.setLayout(new GridLayout(1,1));
		frScrContPanel=new JPanel();
		frScrContPanel.setLayout(new BorderLayout());
		mainPanel=new JPanel();
		mainPanel.setLayout(new BorderLayout());
		btPanel=new JPanel();
		btPanel.setLayout(new GridLayout(0,1));
		tContPanel=new JPanel();
		tContPanel.setLayout(new GridLayout(0,5));
		tMainPanel=new JPanel(new BorderLayout());
		btTPanel=new JPanel(new  GridLayout(0,1));
		
		bNext=new JButton("Next");
		bCancel=new JButton("Cancel");
		bSave=new JButton("Save");
		
		chgCb=new JComboBox();
		chtHCb=new JComboBox(hours);
		chtSCb=new JComboBox(seconds);
		
		
		tContPanel.add(timeCb);
		tContPanel.add(hCb);
		tContPanel.add(chtHCb);
		tContPanel.add(sCb);
		tContPanel.add(chtSCb);
		
		frScrPanel.add(groupCb);
		frScrPanel.add(chgCb);
		
		
		//btPanel.add(bCancel);
		btPanel.add(bNext);
		
		btCancel=new JButton("Cancel");
		btSave=new JButton("Save");
		
		//btTPanel.add(btCancel);
		btTPanel.add(btSave);
		
		
		table=new JTable(new AddAbsencesTable());
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        
      //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        
        bNext.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frScrContPanel.remove(btPanel);
				mainPanel.add(scrollPane,BorderLayout.CENTER);
				mainPanel.add(btTPanel,BorderLayout.SOUTH);
				mainPanel.setOpaque(true);
				thisFrame.pack();
				//thisFrame.pack();
				
			}
		});
		
		tMainPanel.add(frScrPanel,BorderLayout.NORTH);
		tMainPanel.add(tContPanel,BorderLayout.CENTER);
		
		
		frScrContPanel.add(titlePanel,BorderLayout.NORTH);
		frScrContPanel.add(tMainPanel,BorderLayout.CENTER);
		frScrContPanel.add(btPanel,BorderLayout.SOUTH);
		mainPanel.add(frScrContPanel,BorderLayout.NORTH);
		//mainPanel.add(scrollPane,BorderLayout.CENTER);
		this.add(mainPanel,BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	class AddAbsencesTable extends AbstractTableModel{
		private String []columnNames={"ID","First name","Last name","Add absences"};
		private Object [][]data={{new Integer(4),"Smith","Dou",new Boolean(true)}};

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
            if (col == 3) {
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
