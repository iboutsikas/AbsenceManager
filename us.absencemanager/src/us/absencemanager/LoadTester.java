package us.absencemanager;

import java.io.File;
import java.io.IOException;
import java.util.List;

import us.absencemanager.controller.Controller;
import us.absencemanager.model.DataLayer;
import us.absencemanager.model.Student;
import us.absencemanager.model.StudentGroup;
import us.absencemanager.model.Unit;

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
			for(Student s : students) {
				System.out.println(s);
			}
			List<StudentGroup> studentGroups = c.getStudentGroups();
			for (StudentGroup sg: studentGroups) {
				System.out.println(sg);
			}
			List<Unit> units = c.getUnits();
			for(Unit u: units) {
				System.out.println(u);
			}
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
