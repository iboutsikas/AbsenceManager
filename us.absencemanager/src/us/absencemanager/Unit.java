/**
 * 
 */
package us.absencemanager;

/**
 * @author Ioannis Boutsikas
 *
 */
public class Unit {
	private String id;
	private String name;
	private int maxAbsences;
	
	
	/**
	 * @param id
	 * @param name
	 * @param maxAbsences
	 */
	public Unit(String id, String name, int maxAbsences) {
		this.id = id;
		this.name = name;
		this.maxAbsences = maxAbsences;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the maxAbsences
	 */
	public int getMaxAbsences() {
		return maxAbsences;
	}
	/**
	 * @param maxAbsences the maxAbsences to set
	 */
	public void setMaxAbsences(int maxAbsences) {
		this.maxAbsences = maxAbsences;
	}
}
