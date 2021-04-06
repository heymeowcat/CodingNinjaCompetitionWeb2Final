package com.heymeowcat.web2final.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heymeowcat.web2final.entity.Feed;
import com.heymeowcat.web2final.repository.FeedRepository;

@Service
public class FeedService {

	@Autowired
	FeedRepository repository;

	public List<Feed> getAllFeeds() {
		return repository.findAll();
	}

	public List<Feed> getFeedsByKey(String key) {
		return repository.findById(key);
	}

	public Feed addFeed(Feed feed) {
		
		return repository.save(feed);
	}

	public Feed updateFeed(Feed feed) {
		Feed feed2 = repository.findById(feed.getId()).orElse(null);
		if(feed2!=null) {
			feed2.setKeycord(feed.getKeycord());
			feed2.setDescription(feed.getDescription());
			feed2.setAdmin(feed.getAdmin());
			feed2.setStatus(true);
			
			repository.save(feed2);
		}
		
		return feed2;
	}

	public String deleteFeed(int id) {
		Feed feed = repository.findById(id).orElse(null);
		if(feed!=null) {
			repository.delete(feed);
			return "Feed Deleted : "+id;
		}else {
			return "Feed Not Found!";
		}
	}
	

	
	
}
