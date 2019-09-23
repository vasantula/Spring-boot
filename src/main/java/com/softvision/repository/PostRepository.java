package com.softvision.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softvision.bean.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	
	

}
