package us.absencemanager;

import java.util.ArrayList;

public class SerializeReadTest {
	public static void main(String Args[]) {
		Manager m = Manager.getInstance();
		
		m.loadStudentGroups("");
		m.loadStudents("");
		
		ArrayList<Student> students = m.getStudents();
		students.get(0).displayAbsences();		
	}
}
