package com.skilldistillery.xtreme.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.xtreme.repositories.CommentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentRepositoryTest {

	@Autowired
	private CommentRepository comRepo;
	
	@Test
	public void test() {
		assertEquals(1, comRepo.findAll().get(0).getId());
	}

}
