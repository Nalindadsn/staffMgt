package com.admin.staffmanagement.user;

public class User {
	private int id;
	private String name;
	private String note;
	private String attendedDate;
	private String created_at;
	

	public User(int id, String name, String note, String attendedDate, String created_at) {
		super();
		this.id = id;
		this.name = name;
		this.note = note;
		this.attendedDate = attendedDate;
		this.created_at = created_at;
	}

	public User(int id, String name, String note, String attendedDate) {
		super();
		this.id = id;
		this.name = name;
		this.note = note;
		this.attendedDate = attendedDate;
	}
	
	
	public User(String name, String note, String attendedDate) {
		super();
		this.name = name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
