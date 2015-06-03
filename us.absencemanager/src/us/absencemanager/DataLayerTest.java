
package us.absencemanager;

import java.io.File;
import java.io.IOException;

import us.absencemanager.exceptions.AlreadyExistsException;
import us.absencemanager.exceptions.NoDataFoundException;
import us.absencemanager.model.DataLayer;
import us.absencemanager.model.Student;

public class DataLayerTest {

	public static void main(String[] args) {
		DataLayer dl = DataLayer.getInstance();
		Student s1 = new Student("CS14045", "Ioannis", "Boutsikas", "test@mail.com");
		Student s2 = new Student("CS14047", "John", "Doe", "test@mail.com");
		Student s3 = new Student("CS14048", "Jane", "Doe", "test@mail.com");
		Student s4 = new Student("CS14049", "Will", "Smith", "test@mail.com");
		try {
			dl.addStudent(s1);
			dl.addStudent(s2);
			dl.addStudent(s3);
			dl.addStudent(s4);
			System.out.println("--- Added students ---");
			dl.saveStudents(new File("students.dat"));
			System.out.println("--- Saved students ---");
			
			//dl.loadStudents(new File("students.dat"));
			//System.out.println("--- Loaded students ---");
			
			Student s = dl.findStudentById("CS14045");
			System.out.println(s);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoDataFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
