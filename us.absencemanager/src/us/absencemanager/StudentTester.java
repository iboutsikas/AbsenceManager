package us.absencemanager;



public class StudentTester {

	public static void main(String[] args) {
		Student s = new Student("CS14045", "Ioannis", "Boutsikas", "ib@foo.gr");
		
		s.addAbsence("CCP1700", new Absence("CCP1700", "L3-L4"));
		
		s.displayAbsences();
		//System.out.println(s.getAbsenceList("CCP1700")); 

	}

}
