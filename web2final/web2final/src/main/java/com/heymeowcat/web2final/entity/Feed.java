package com.heymeowcat.web2final.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

@Entity(name="Feed")
@Table(name="feed")
public class Feed implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String keycord;
	private String description;
	private boolean status;
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="id_admin")
	private Admin admin;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getKeycord() {
		return keycord;
	}


	public void setKeycord(String keycord) {
		this.keycord = keycord;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	
	
	
}