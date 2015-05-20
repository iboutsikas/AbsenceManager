package us.absencemanager;


public class GroupSerializeTest {
	
	public static void main(String[] args) {   
		Manager m = Manager.getInstance();
		
		Student s1 = new Student("CS14009", "John", "Doe", "jd@foo.com");
		Student s2 = new Student("CS14045", "Jane", "Doe", "jd2@foo.com");
		s1.addAbsence("CCP1700", new Absence("CCP1700","L6"));
		s1.addAbsence("CCP1700", new Absence("CCP1700","L3-L4"));
		s1.addAbsence("CCP1600", new Absence("CCP1600","MP Room"));
		
		
		StudentGroup2 sg = new StudentGroup2("MyTestGroup");
		sg.addStudent(s1);
		sg.addStudent(s2);
		
		m.addStudentGroup(sg);
		m.addStudent(s1);
		m.addStudent(s2);
		
		m.saveStudents("");
		m.saveStudentGroups("");
		
				
	}
}
