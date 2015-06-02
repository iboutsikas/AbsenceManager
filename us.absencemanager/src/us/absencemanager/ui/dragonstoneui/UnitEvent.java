<<<<<<< HEAD
package us.absencemanager.ui.dragonstoneui;

public class UnitEvent extends CustomEvent {
	String id;
	String name;
	int abs;
	public UnitEvent(Object source) {
		super(source);
	}
	
	public UnitEvent(Object source, String id, String name, int abs) {
		super(source);
		this.id = id;
		this.name = name;
		this.abs = abs;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the abs
	 */
	public int getAbs() {
		return abs;
	}
	
}
=======
package us.absencemanager.ui.dragonstoneui;

public class UnitEvent extends CustomEvent {
	String id;
	String name;
	int abs;
	public UnitEvent(Object source) {
		super(source);
	}
	
	public UnitEvent(Object source, String id, String name, int abs) {
		super(source);
		this.id = id;
		this.name = name;
		this.abs = abs;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the abs
	 */
	public int getAbs() {
		return abs;
	}
	
}
>>>>>>> refs/heads/devB
