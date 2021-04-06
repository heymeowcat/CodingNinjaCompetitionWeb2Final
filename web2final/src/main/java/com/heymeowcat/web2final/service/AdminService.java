package com.heymeowcat.web2final.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heymeowcat.web2final.entity.Admin;
import com.heymeowcat.web2final.repository.adminRepository;

@Service
public class adminService {

	@Autowired
	adminRepository adminRepo;

//save admin here
	public Admin saveAdminDetails(Admin adminOBJ) {
		return adminRepo.save(adminOBJ);
	}

//update admin here
	public Admin updateAdminProfile(Admin updatedAdminOBJ) {
		Admin adminResultOBJ = adminRepo.findById(updatedAdminOBJ.getId()).orElse(null);
		if(adminResultOBJ!=null) {
			adminResultOBJ.setName(updatedAdminOBJ.getName());
			adminResultOBJ.setEmail(updatedAdminOBJ.getEmail());
			adminResultOBJ.setMobile(updatedAdminOBJ.getMobile());
			adminResultOBJ.setUsername(updatedAdminOBJ.getUsername());
                        adminResultOBJ.setPassword(updatedAdminOBJ.getPassword());
                        adminResultOBJ.setStatus(updatedAdminOBJ.getStatus());
                        adminResultOBJ.setDateCreated(updatedAdminOBJ.getDateCreated());
                        adminResultOBJ.setLastUpdated(updatedAdminOBJ.getLastUpdated());
			
			adminRepo.save(adminResultOBJ);
		}
		
		return adminResultOBJ;
	}

//delete admin permanatly here
	public String deleteAdmin(int idAdmin) {
		Admin adminOBJ = adminRepo.findById(idAdmin).orElse(null);
		if(adminOBJ!=null) {
			adminRepo.delete(adminOBJd);
			return "Delete Admin : "+idAdmin;
		}else {
			return "No support admin found!";
		}
	}

//delete admin temporary here
	public Admin updateAdminProfile(int idAdmin) {
		Admin adminResultOBJ = adminRepo.findById(int idAdmin).orElse(null);
		if(adminResultOBJ!=null) {
			adminResultOBJ.setName(updatedAdminOBJ.getName());
			adminResultOBJ.setEmail(updatedAdminOBJ.getEmail());
			adminResultOBJ.setMobile(updatedAdminOBJ.getMobile());
			adminResultOBJ.setUsername(updatedAdminOBJ.getUsername());
                        adminResultOBJ.setPassword(updatedAdminOBJ.getPassword());
                        adminResultOBJ.setStatus("Deleted");
                        adminResultOBJ.setDateCreated(updatedAdminOBJ.getDateCreated());
                        adminResultOBJ.setLastUpdated(updatedAdminOBJ.getLastUpdated());
			
			adminRepo.save(adminResultOBJ);
		}
		
		return adminResultOBJ;
	}
	
//get all admin list here
	public List<Admin> getAllAdmins() {
		return adminRepo.findAll();
	}

	
}
