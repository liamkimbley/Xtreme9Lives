package com.skilldistillery.xtreme.services;

import java.util.List;

import com.skilldistillery.xtreme.Comment;

public interface CommentService {
	
	public List<Comment> findCommentsByPost(int id);
	public Comment createNewCommentOnPost(int id, Comment comment);
	public boolean deleteCommentById(int cid);

}
