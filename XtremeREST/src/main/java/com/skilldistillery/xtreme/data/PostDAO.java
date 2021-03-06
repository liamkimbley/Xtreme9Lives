package com.skilldistillery.xtreme.data;

import java.util.List;

import com.skilldistillery.xtreme.Post;

public interface PostDAO {
	
	public List<Post> getAllPosts();
	public Post getPostById(int pid);
	public Post createPost(Post post);
	public Post updatePost(int pid, Post post);
	public Post replacePost(int pid, Post post);
	public boolean deletePost(int pid);
}
