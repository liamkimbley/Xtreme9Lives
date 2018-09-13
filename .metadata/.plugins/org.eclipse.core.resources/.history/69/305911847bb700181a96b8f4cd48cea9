package com.skilldistillery.xtreme.services;

import java.util.List;

import com.skilldistillery.xtreme.Post;

public interface PostService {
	
	public List<Post> findPostsByCategoryId(int id);
	public List<Post> searchPostsByName(String name);
	public List<Post> searchPostsByTitle(String title);
	public List<Post> findPostsByPriceRange(double lowest, double highest);
	public List<Post> findAllPosts();
	public Post findPostById(int id);
	public Post create(Post post);
	public Post update(int id, Post post);
	public Post replace(int id, Post post);
	public boolean delete(int id);
	
}
