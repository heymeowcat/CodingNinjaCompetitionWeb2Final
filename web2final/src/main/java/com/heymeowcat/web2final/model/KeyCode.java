package com.heymeowcat.web2final.model;


import lombok.NoArgsConstructor;


@NoArgsConstructor
public class KeyCode {

	private int id;
	private String keycode;
	
	
	public KeyCode(int id, String keycode) {
		super();
		this.id = id;
		this.keycode = keycode;
	}
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
	
	
	
	
}
