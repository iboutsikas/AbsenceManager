package us.absencemanager.ui.dragonstoneui;

import java.util.EventObject;

public class StudentEvent extends CustomEvent {
	private String id;
	private String fName;
	private String lName;
	private String email;
	private Boolean add;
	
	public StudentEvent(Object source) {
		super(source);
	}
	
	public StudentEvent(Object source, String id, String fName, String lName, String email, Boolean add) {
		super(source);
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.add = add;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the add
	 */
	public Boolean getAdd() {
		return add;
	}
}
