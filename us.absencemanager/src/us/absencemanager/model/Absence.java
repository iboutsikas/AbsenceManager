
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
	
	public String getDate() {
		return date;
	}

	public String getClassroom() {
		return classroom;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((classroom == null) ? 0 : classroom.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((unitId == null) ? 0 : unitId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Absence other = (Absence) obj;
		if (classroom == null) {
			if (other.classroom != null)
				return false;
		} else if (!classroom.equals(other.classroom))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (unitId == null) {
			if (other.unitId != null)
				return false;
		} else if (!unitId.equals(other.unitId))
			return false;
		return true;
	}
	
}
