package com.twitter;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.twitter.model.Crediantails;
import com.twitter.model.Posts;
import com.twitter.model.User_twitter;
import com.twitter.service.TwitterService;

@SpringBootTest
class TwitterApplicationTests {



	Posts posts;
	User_twitter user;
	Crediantails c;
	List<Posts> p1=new ArrayList<Posts>();
	List<User_twitter> u1=new ArrayList<User_twitter>();
	TwitterService ts=Mockito.mock(TwitterService.class);
	@Test
	void contextLoads() {
	}

	@BeforeEach
	void init() {
		posts=new Posts();
		c=new Crediantails("sai","sai");
		Posts p=new Posts(1,c,"hai");
		Posts p2=new Posts(2,c,"hello");
		p1.add(p2);p1.add(p);
	}
	@Test
	void testPostSame() {
		Posts p1=posts;
		assertSame(posts, p1);
	}
	@Test
	void testAssertEqualsPosts() {
		assertEquals(posts, posts);
	}
	@Test
	void testAssertEqualsCrediantails() {
		assertEquals("sai","sai");
	}
	@Test 
	void testAssertNotEqualsUser() {
		user=new  User_twitter(c, p1, 0, 0, 0);
		assertNotEquals(user.getCs().getUsername(),"teja"); 
	}

	@Test 
	void testNullExceptionPosts() {
		assertThrows(NullPointerException.class,()->posts.getPost().length());
	}

	@Test 
	void testNotNullCrediantails() { 
		Crediantails c1 = new Crediantails("sai","ram");
		Posts p=new Posts(1,c1,"hai");
		assertNotNull(p.getCs().getUsername());
	}
	@Test 
	void testNotNullUserDetails() {
		user=new  User_twitter(c, p1, 0, 0, 0);
		assertNotNull(user.getFollowers()); 
	}
	@Test 
	void testNullExceptionServiceGetPost() { 
		doThrow(new NullPointerException()).when(ts).getPosts(c);
	}

	@Test 
	void testNullExceptionServiceDeletePost() { 
		doThrow(new NullPointerException()).when(ts).deleteposts(0);
	}
	@Test 
	void testGettinggCrediantailsUsingService() {
		c=new Crediantails("sai","sai");
		when(ts.getPosts(c)).thenReturn(p1);
	}
	@Test 
	void testGettingAllPostsInService() { 
		ts.getAllPosts();verify(ts,times(1)).getAllPosts();
	}
	@Test 
	void testGettingAllPosts() { 
		doReturn(p1).when(ts).getAllPosts();
	}
	@Test
	void testVerifyPosts() {
		c=new Crediantails("sai","sai");
		verify(ts,never()).getPosts(c); 
	}
	@Test
	void testGetAllPostsVerify() { 
		when(ts.getAllPosts()).thenReturn(p1);
		assertEquals(p1,ts.getAllPosts());
		verify(ts,atLeast(1)).getAllPosts();
	}
	@Test 
	void testAssertEqualsOnGetAllPosts() { 
		when(ts.getAllPosts()).thenReturn(p1);
		assertEquals(2,p1.size()); 
	}

}
