package com.heymeowcat.web2final.jwtFilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.heymeowcat.web2final.service.AdminService;
import com.heymeowcat.web2final.service.util.JwtUtil;

import antlr.Token;

@Component
public class JwtFilter extends OncePerRequestFilter{

	@Autowired
	private JwtUtil util;
	@Autowired
	private AdminService service;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkdWwiLCJleHAiOjE2MTc2NzA2NzQsImlhdCI6MTYxNzYzNDY3NH0.O3gnzXxOT0Gua9fjWJNCKjCnqDtPE_vWOWPW2YepNL4
		String authherizationHeader = request.getHeader("Authorization");
		String token = null;
		String username = null;
		if(authherizationHeader!=null && authherizationHeader.startsWith("Bearer")) {
			token = authherizationHeader.substring(7);
			username = 	util.extractUsername(token);
		}
			if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				
				UserDetails userDetails =  service.loadUserByUsername(username);
				if(util.validateToken(token, userDetails)) {
					UsernamePasswordAuthenticationToken upaToken = new UsernamePasswordAuthenticationToken(
							userDetails, null,userDetails.getAuthorities());
					upaToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
					SecurityContextHolder.getContext().setAuthentication(upaToken);
				}
				
			}
			filterChain.doFilter(request, response);
		
	}

}
