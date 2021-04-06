package com.heymeowcat.web2final.model;


import lombok.NoArgsConstructor;


@NoArgsConstructor
public class KeyCode {

	private int id;
	private String keycode;
	private String description;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKeycode() {
		return keycode;
	}
	public void setKeycode(String keycode) {
		this.keycode = keycode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public KeyCode(int id, String keycode, String description) {
		this.id = id;
		this.keycode = keycode;
		this.description = description;
	}
	
	
	
	
}
