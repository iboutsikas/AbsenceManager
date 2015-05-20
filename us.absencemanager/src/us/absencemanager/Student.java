/**
 * 
 */
package us.absencemanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Ioannis Boutsikas
 *
 */
public class Student implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 295796725147927652L;
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private Map<String, ArrayList<Absence>> absences;
	
	public void addAbsence(String unitID, Absence a) {
		try {
			ArrayList<Absence> temp = absences.get(unitID);
			if(temp !=null) {
				temp.add(a);
			} else {
				temp = new ArrayList<Absence>();
				temp.add(a);
			}
			absences.put(unitID, temp);
		}
		catch(ClassCastException | NullPointerException e) {
			System.out.println("Could not add absence");
		}
	}
	
	/**
	 * Displays all the absences in sysout, in tabular format.
	 */
	public void displayAbsences() {
		for(Map.Entry<String, ArrayList<Absence>> entry : absences.entrySet()) {
			String key = entry.getKey();
			ArrayList<Absence> value = entry.getValue();
	
			System.out.println("Unit "+ key +":");
			for(Absence a : value) {
				System.out.println("\t"+a);
			}
		}
	}
	/**
	 * @param id the Unit to get Absences for.
	 * @return ArrayList<Absence> the Absences for the unit specified
	 */
	public ArrayList<Absence> getAbsenceList(String id) {
		ArrayList<Absence> temp = this.absences.get(id);	
		return temp;
	}	
	
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public Student(String id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		absences = new TreeMap<String, ArrayList<Absence>>();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + "]";
	}
	
}
