package com.heymeowcat.web2final.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.heymeowcat.web2final.entity.Admin;
import com.heymeowcat.web2final.repository.AdminRepository;

@Service
public class AdminService implements UserDetailsService{

	@Autowired
	AdminRepository repository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
//		repository.findById(null);
		Admin admin =  repository.findByUsername(username);
		if(admin!=null) {		
			return new org.springframework.security.core.userdetails.User(admin.getUsername(), admin.getPassword(), new ArrayList<>());
		}else {
			return null;
		}
	
	
	}



	public List<Admin> getAllAdmin() {
		return repository.findAll();
	}



	public Admin addAdmin(Admin admin) {
		return repository.save(admin);
	}



	public Admin updateAdmin(Admin admin) {
		
		Admin am = repository.findById(admin.getId()).orElse(null);
		if(am!=null) {
			am.setEmail(admin.getEmail());
			am.setMobile(admin.getMobile());
			am.setName(admin.getName());
			am.setPassword(admin.getPassword());
			am.setStatus(true);
			am.setUsername(admin.getUsername());
			
			repository.save(am);
		}
		return am;
	}



	public String deleteAdmin(int id) {
		Admin admin = repository.findById(id).orElse(null);
		if(admin!=null) {
			repository.delete(admin);
			return "Admin Deleted : "+id;
		}else {
			return "Admin Not Found!";
		}
	}
	
}
