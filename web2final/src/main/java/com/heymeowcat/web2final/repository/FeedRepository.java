package com.heymeowcat.web2final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heymeowcat.web2final.entity.Feed;

@Repository
public interface FeedRepository extends JpaRepository<Feed, Integer>{

}
