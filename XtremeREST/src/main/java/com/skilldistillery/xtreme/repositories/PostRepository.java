package com.skilldistillery.xtreme.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.xtreme.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	public List<Post> findByNameContaining(String name);
	public List<Post> findByTitleContaining(String title);

	@Query("SELECT p FROM Post p WHERE p.category.id = :id")
	public List<Post> queryForCategoryId(int id);
	
	@Query("SELECT p FROM Post p JOIN FETCH p.comments WHERE p.id = :id")
	public Post queryForPostWithCommentsByPostId(int id);
	
	@Query("SELECT p FROM Post p WHERE p.price BETWEEN :low AND :high")
	public List<Post> queryForPostByPriceRange(@Param("low") double lowest, @Param("high") double highest);
	
}
