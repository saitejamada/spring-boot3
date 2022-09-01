package com.bloodbank;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import com.bloodbank.model.Donor;
import com.bloodbank.model.Order;

import com.bloodbank.model.Permission;
import com.bloodbank.model.Role;

import com.bloodbank.model.User;

@SpringBootTest
class BloodBankApplicationTests {

	Role r1;
	Role r;
	Order or;
	Donor d;
	
	@BeforeEach
	void init() {
		 r=new Role("admin", "has all permissions");
		Permission p=new Permission("admin", r);
		 or=new Order("online","urgent requirement");
		User u=new User("saiteja","sai@abc.com", new Date(96, 5, 10), "hyderabad", "sai", r, p, or);
		d=new Donor("saiteja mada", "8499995950", "sai@abc.com", "hyderabad", u);
	}
	
	

	@Test
	void test1() {
		assertNotSame(r,r1);
	}
	@Test
	void test2() {
		assertFalse(r==r1);
	}
	@Test
	void test3() {
		assertNotEquals(r, r1);
	}
	@Test
	void test4() {
		assertEquals("admin", r.getRole_title());
	}
	@Test
	void test5() {
		assertEquals("online",or.getType());
	}
	
	@Test
	void test6() {
		assertNotNull(or);
	}
	@Test
	void test7() {
		assertNull(r1);
	}
	@Test
	void test8() {
		assertNotNull(d);
	}
	@Test
	void test9() {
		assertEquals("saiteja mada",d.getName());
	}
	@Test
	void test10() {
		assertTrue(true);
	}
}
