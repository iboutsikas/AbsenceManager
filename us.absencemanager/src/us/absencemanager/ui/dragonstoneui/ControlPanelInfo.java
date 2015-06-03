package us.absencemanager.ui.dragonstoneui;

public class ControlPanelInfo {
	private int groupId;
	private String unitId;
	private String dateTime;
	private String classroom;
	
	
	public int getGroupId() {
		return groupId;
	}


	public String getUnitId() {
		return unitId;
	}


	public String getDateTime() {
		return dateTime;
	}


	public String getClassroom() {
		return classroom;
	}


	public ControlPanelInfo(int groupId, String unitId, String dateTime, String classroom) {
		super();
		this.groupId = groupId;
		this.unitId = unitId;
		this.dateTime = dateTime;
		this.classroom = classroom;
	}
	
	
					
}
