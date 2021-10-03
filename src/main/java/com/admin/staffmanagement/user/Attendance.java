package com.admin.staffmanagement.user;

public class Attendance {
	private int id;
	private String staffId;
	private String note;
	private String attendedDate;
	private String created_at;
	

	public Attendance(int id, String staffId, String note, String attendedDate, String created_at) {
		super();
		this.id = id;
		this.staffId = staffId;
		this.note = note;
		this.attendedDate = attendedDate;
		this.created_at = created_at;
	}

	public Attendance(int id, String staffId, String note, String attendedDate) {
		super();
		this.id = id;
		this.staffId = staffId;
		this.note = note;
		this.attendedDate = attendedDate;
	}
	
	
	public Attendance(String staffId, String note, String attendedDate) {
		super();
		this.staffId = staffId;
		this.note = note;
		this.attendedDate = attendedDate;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getAttendedDate() {
		return attendedDate;
	}
	public void setAttendedDate(String attendedDate) {
		this.attendedDate = attendedDate;
	}
	

}
