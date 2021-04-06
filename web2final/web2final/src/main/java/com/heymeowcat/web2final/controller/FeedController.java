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

import com.heymeowcat.web2final.entity.Feed;
import com.heymeowcat.web2final.model.KeyCode;
import com.heymeowcat.web2final.service.FeedService;

@RestController
@RequestMapping("/feed")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class FeedController {

	@Autowired
	FeedService service;
	
	@GetMapping("/getAll")
	public List<Feed> getAllFeeds(){
	  return service.getAllFeeds();
	}
	
	@GetMapping("getFeedByName/{key}")
	public List<Feed> getFeedsByName(@PathVariable String key){
		return service.getFeedsByKey(key);
	}
	
	@PostMapping("/addFeed")
	public Feed saveFeed(@RequestBody Feed feed){
		return service.addFeed(feed);
	}
	
	@PutMapping("/updateFeed")
	public Feed updateFeed(@RequestBody Feed feed) {
		return service.updateFeed(feed);
	}
	
	@DeleteMapping("/deleteFeed/{id}")
	public String deleteFeed(@PathVariable int id) {
		return service.deleteFeed(id);
	}
	
	
	@GetMapping("getFeedsLike/{key}")
	public List<KeyCode> getFeedsByKeyCodeLike(@PathVariable String key){
		return service.getFeedsByKeyCodeLike(key);
	}
	
	
	
	
	
}
