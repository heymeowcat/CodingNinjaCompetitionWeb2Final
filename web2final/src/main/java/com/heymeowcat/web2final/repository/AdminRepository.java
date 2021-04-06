package com.heymeowcat.web2final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heymeowcat.web2final.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Admin findByUsername(String username);

}
