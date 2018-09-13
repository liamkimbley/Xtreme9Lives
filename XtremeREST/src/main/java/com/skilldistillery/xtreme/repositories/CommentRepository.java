package com.skilldistillery.xtreme.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.xtreme.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	@Query("SELECT c From Comment c WHERE c.post.id = :id")
	public List<Comment> queryForCommentsByPostId(@Param("id") int id);
}
