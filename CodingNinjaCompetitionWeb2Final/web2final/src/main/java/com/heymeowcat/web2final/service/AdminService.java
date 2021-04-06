package com.heymeowcat.web2final.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
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
	
}
