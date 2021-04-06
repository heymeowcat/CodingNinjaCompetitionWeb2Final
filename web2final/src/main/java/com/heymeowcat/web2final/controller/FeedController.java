//package com.heymeowcat.web2final.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.heymeowcat.web2final.entity.Feed;
//import com.heymeowcat.web2final.service.FeedService;
//
//@RestController
//@RequestMapping("/feed")
//@CrossOrigin(origins = "*",allowedHeaders = "*")
//public class FeedController {
//
//	@Autowired
//	FeedService service;
//	
//	@GetMapping("/getAll")
//	public List<Feed> getAllFeeds(){
//	  return service.getAllFeeds();
//	}
//	
//	@GetMapping("getFeedByName/{key}")
//	public List<Feed> getUserByNameAndAge(@PathVariable String key){
//		return service.getFeedsByKey(key);
//	}
//	
//	
//	
//}
