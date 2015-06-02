<<<<<<< HEAD
/**
 * 
 */
package us.absencemanager.model;

import java.io.Serializable;

/**
 * Represents a unit with a specific ID, name, and the maximum allowed absences
 * @author Ioannis Boutsikas
 *
 */
public class Unit implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 395538694810778557L;
	private String id;
	private String name;
	private int maxAbsences;
	
	
	/**
	 * Constructs and initializes a Unit with given ID, name, and maxAbsences.
	 * @param id The Unit id
	 * @param name The Unit name
	 * @param maxAbsences The maximum allowed absences
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unit other = (Unit) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		//return "Unit [id=" + id + ", name=" + name + "]";
		return id+" - "+name;
	}
}
=======
/**
 * 
 */
package us.absencemanager.model;

import java.io.Serializable;

/**
 * Represents a unit with a specific ID, name, and the maximum allowed absences
 * @author Ioannis Boutsikas
 *
 */
public class Unit implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 395538694810778557L;
	private String id;
	private String name;
	private int maxAbsences;
	
	
	/**
	 * Constructs and initializes a Unit with given ID, name, and maxAbsences.
	 * @param id The Unit id
	 * @param name The Unit name
	 * @param maxAbsences The maximum allowed absences
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unit other = (Unit) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		//return "Unit [id=" + id + ", name=" + name + "]";
		return id+" - "+name;
	}
}
>>>>>>> refs/heads/devB
