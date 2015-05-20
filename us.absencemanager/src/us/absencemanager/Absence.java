
package us.absencemanager;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

/**
 * The Absence class, represents a specific Absence, with unit ID, classroom, and date.
 * @author Zinadore
 */

public class Absence implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6884187116361801298L;
	private String unitID;
	private Date date;
	private String classroom;
	
	/**
	 * Constructs and initializes a new Absence with unitID and the classroom. Date is set to the closest rounded down hour.
	 * @param unitID The unit id for the absence.
	 * @param classroom The classroom the absence was taken in
	 */
	public Absence (String unitID, String classroom) {
		setUnitID(unitID);
		setClassroom(classroom);
		setDate();
	}

	private void setDate() {
		Date temp = new Date();
		this.date = DateUtils.truncate(temp, Calendar.HOUR);
	}

	private void setClassroom(String classroom) {
		//TODO VALIDATE DATA. THERE IS NO VALIDATION ATM
		this.classroom = classroom;
	}

	private void setUnitID(String unitID) {
		// TODO VALIDATE DATA. THERE IS NO VALIDATION ATM
		this.unitID = unitID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Absence [unitID=" + unitID + ", date=" + date + ", classroom="
				+ classroom + "]";
	}
	
}
