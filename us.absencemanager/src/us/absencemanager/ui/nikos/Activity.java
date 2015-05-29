package us.absencemanager.ui.nikos;


public class Activity {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Main mD = new Main();
            }
        });
	}

}
