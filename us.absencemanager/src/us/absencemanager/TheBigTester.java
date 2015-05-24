package us.absencemanager;

import java.io.IOException;

import us.absencemanager.controller.Controller;
import us.absencemanager.exceptions.AlreadyExistsException;
import us.absencemanager.exceptions.NoDataFoundException;


public class TheBigTester {
	public static void main(String[] args) throws AlreadyExistsException, IOException{
		Controller c = Controller.getInstance();
		
		System.out.println("Adding first student");
		c.addStudent("CS14045", "Ioannis", "Boutsikas", "test@mail.com");
		c.addStudent("CS14046", "Jane", "Doe", "test@mail.com");
		c.addStudent("CS14047", "John", "Doe", "test@mail.com");
		c.addStudent("CS14048", "Will", "Smith", "test@mail.com");
		c.addStudent("CS14049", "Random", "Randomson", "test@mail.com");
		try {
			System.out.println("Adding the same student");
			c.addStudent("CS14045", "Ioannis", "Boutsikas", "test@mail.com");
		} catch(AlreadyExistsException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("Adding the student group");
		c.addStudentGroup("My first group");
		
		try {
			c.addStudentToGroup("CS14045", 1);
			c.addStudentToGroup("CS14048", 1);
			System.out.println("Adding the same student to the group");
			c.addStudentToGroup("CS14045", 1);
		} catch (NoDataFoundException e) {
			System.err.println(e.getMessage());
		} catch (AlreadyExistsException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			c.addAbsenceToStudent("CS14045", "CPP1600", "L6", "24-5-2015 17:00");
			c.addAbsenceToStudent("CS14046", "CPP1600", "L6", "24-5-2015 17:00");
			c.addAbsenceToStudent("CS14046", "CPP1700", "L3-L4", "17-5-2015 09:00");
			c.addAbsenceToStudent("CS14045", "CPP1700", "L3-L4", "17-5-2015 09:00");
			c.addAbsenceToStudent("CS14045", "CPP1800", "L6", "24-5-2015 15:00");
			System.out.println("Adding to wrong id");
			c.addAbsenceToStudent("CS14050", "CPP1600", "L6", "24-5-2015 17:00");
		} catch (NoDataFoundException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("Adding units");
		c.addUnit("CPP1700", "Introduction to Object-Orientation", 12);
		c.addUnit("CPP1600", "Network Architectures", 6);		
		
		try {
			c.saveAll("");
		} catch (IOException e) {
			throw e;
		}
		
	}
}
