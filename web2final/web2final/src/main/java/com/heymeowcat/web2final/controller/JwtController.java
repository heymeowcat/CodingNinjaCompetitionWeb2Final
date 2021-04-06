package com.heymeowcat.web2final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heymeowcat.web2final.model.AuthRequest;
import com.heymeowcat.web2final.service.util.JwtUtil;



@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class JwtController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager auth_manager;
	
	
	@GetMapping("/")
	public String jwtTest() {
		return "welcome!";
	}
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authrequest) {
		
		try {
			auth_manager.authenticate(new UsernamePasswordAuthenticationToken(authrequest.getUsername(), authrequest.getPassword()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jwtUtil.generateToken(authrequest.getUsername());
	}
	
	
	
}
