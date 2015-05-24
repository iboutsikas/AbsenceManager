
package us.absencemanager.model;

import java.io.Serializable;

/**
 * The Absence class, represents a specific Absence, with unit ID, classroom, and date.
 * @author Zinadore
 */

public class Absence implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6884187116361801298L;
	private String unitId;
	private String date;
	private String classroom;
	
	/**
	 * Constructs and initializes a new Absence with unitID and the classroom. Date is set to the closest rounded down hour.
	 * @param unitID the unit id for the absence.
	 * @param classroom the classroom the absence was taken in
	 * @param date a string representation of the date
	 */
	public Absence (String unitId, String classroom, String date) {
		this.unitId = unitId;
		this.classroom = classroom;
		this.date = date;
	}
	
	public String getUnitId() {
		return this.unitId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Absence [unitID=" + unitId + ", date=" + date + ", classroom="
				+ classroom + "]";
	}
	
}
