package us.absencemanager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import us.absencemanager.controller.Controller;
import us.absencemanager.model.Absence;
import us.absencemanager.model.DataLayer;
import us.absencemanager.model.Student;

public class LoadTester {
	public static void main(String[] args){
		Controller c = Controller.getInstance();
		DataLayer dl = DataLayer.getInstance();
		try {
//			dl.loadStudents(new File("students.dat"));
//			dl.loadStudentGroups(new File("studentGroups.dat"));
//			dl.loadUnits(new File("units.dat"));
			c.loadAll();
			List<Student> students = c.getStudents();
//			for(Student s : students) {
//				System.out.println(s);
//			}
//			student
//			
//			List<StudentGroup> studentGroups = c.getStudentGroups();
//			for (StudentGroup sg: studentGroups) {
//				System.out.println(sg);
//			}
//			List<Unit> units = c.getUnits();
//			for(Unit u: units) {
//				System.out.println(u);
//			}
		    Student s =	students.get(0);
		    Map<String, ArrayList<Absence>> absences = s.getAbsences();
			
		    for (String k: absences.keySet()) {
		    	ArrayList<Absence> list = absences.get(k);
		    	for(Absence a: list) {
		    		System.out.println(a);
		    	}
		    }
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
