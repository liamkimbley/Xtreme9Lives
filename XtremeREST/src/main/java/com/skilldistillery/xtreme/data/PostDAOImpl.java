package com.skilldistillery.xtreme.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.xtreme.Category;
import com.skilldistillery.xtreme.Post;

@Transactional
@Service
public class PostDAOImpl implements PostDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Post> getAllPosts() {
		String query = "SELECT p FROM Post p";
		return em.createQuery(query, Post.class).getResultList();
	}

	@Override
	public Post getPostById(int pid) {
		return em.find(Post.class, pid);
		
	}

	@Override
	public Post createPost(Post post) {
		try {
			post.setCategory(em.find(Category.class, 5));
			em.persist(post);
			em.flush();
			return post;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Post replacePost(int pid, Post post) {
		Post p = em.find(Post.class, pid);
		p.setBrand(post.getBrand());
		p.setCategory(post.getCategory());
		p.setComments(post.getComments());
		p.setDescription(post.getDescription());
		p.setEmail(post.getEmail());
		p.setImageURL(post.getImageURL());
		p.setName(post.getName());
		p.setPrice(post.getPrice());
		p.setTitle(post.getTitle());
		p.setUpdatedAt(post.getCreatedAt());
		
		return p;
		
	}

	@Override
	public Post updatePost(int pid, Post post) {
		Post p = em.find(Post.class, pid);
		
		if (post.getBrand() != null) {
			p.setBrand(post.getBrand());
		}
		if (post.getCategory() != null) {
			p.setCategory(post.getCategory());
		}
		if (post.getComments() != null) {
			p.setComments(post.getComments());
		}
		if (post.getDescription() != null) {
			p.setDescription(post.getDescription());
		}
		if (post.getEmail() != null) {
			p.setEmail(post.getEmail());
		}
		if (post.getImageURL() != null) {
			p.setImageURL(post.getImageURL());
		}
		if (post.getName() != null) {
			p.setName(post.getName());
		}
		if (post.getPrice() != 0.0) {
			p.setPrice(post.getPrice());
		}
		if (post.getTitle() != null) {
			p.setTitle(post.getTitle());
		}
		return p;		
	}

	@Override
	public boolean deletePost(int pid) {
		em.getTransaction().begin();
		em.remove(em.find(Post.class, pid));
		em.getTransaction().commit();
		if (em.find(Post.class, pid) == null) {
			return true;
		}
		else {
			return false;
		}
	}

}
