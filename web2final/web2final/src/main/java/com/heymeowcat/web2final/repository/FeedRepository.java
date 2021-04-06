package com.heymeowcat.web2final.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.heymeowcat.web2final.entity.Feed;
import com.heymeowcat.web2final.model.KeyCode;

@Repository
public interface FeedRepository extends JpaRepository<Feed, Integer>{

	List<Feed> findById(String key);

	@Query("SELECT new com.heymeowcat.web2final.model.KeyCode(f.id,f.keycord) FROM Feed f WHERE f.keycord LIKE ?1%")
	public List<KeyCode> getFeedsByKeyCode(String keycode);
	
	
	
}
