package com.heymeowcat.web2final.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heymeowcat.web2final.entity.Admin;
import com.heymeowcat.web2final.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AdminController {

	@Autowired
	AdminService service;
	
	@GetMapping("/getAllAdmins")
	public List<Admin> getAllAdmins(){
	  return service.getAllAdmin();
	}
	
	@PostMapping("/addAdmin")
	public Admin saveAdmin(@RequestBody Admin admin){
		return service.addAdmin(admin);
	}
	
	@PutMapping("/updateAdmin")
	public Admin updateAdmin(@RequestBody Admin admin) {
		return service.updateAdmin(admin);
	}
	
	@DeleteMapping("/deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable int id) {
		return service.deleteAdmin(id);
	}
	
	
	
}
