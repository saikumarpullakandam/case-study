package com.cap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cap.admin.controller.AdminController;
import com.cap.admin.model.Admin;
import com.cap.admin.model.Role;
import com.cap.admin.service.AdminService;


@SpringBootTest(classes=ControllerMockitoTest.class)
public class ControllerMockitoTest {

	@InjectMocks
	AdminController controller;
	
	
	@Mock
	AdminService service;
	
     Admin admin;
     
     @Mock
     PasswordEncoder passwordEncoder;
     
  
     
	
	@Test
	public void TestAddAdmin()
	{
		Set<Role> role1 = new HashSet<Role>();
		role1.add(new Role("1","Admin"));
		 admin = new Admin ("1","sai","Kumar","pullakandam","xyz@gmail.com","1234",role1,"saii");
     	when(service.createAdmin(admin)).thenReturn(admin);
        assertEquals(admin, controller.addAdmin(admin));
 
	}
	
	@Test
	public void TestUpdateById()
	{
		Set<Role> role1 = new HashSet<Role>();
		role1.add(new Role("1","Admin"));
		 admin = new Admin ("1","sai","Kumar","pullakandam","xyz@gmail.com","1234",role1,"saii");
		 when(service.updateById("1", admin)).thenReturn(admin);
		assertEquals(admin,controller.update("1", admin));
	}
	
	@Test
	public void TestFindByName()
	{
		Set<Role> role1 = new HashSet<Role>();
		role1.add(new Role("1","Admin"));
		 admin = new Admin ("1","sai","Kumar","pullakandam","xyz@gmail.com","1234",role1,"saii");
		 when(service.findUserName("saii")).thenReturn(admin);
		 assertEquals(admin,controller.getByName("saii"));
		
	}

	
	
	
	@Test
	public void TestDeleteAdmin()
	{
		Set<Role> role1 = new HashSet<Role>();
		role1.add(new Role("1","Admin"));
		 admin = new Admin ("1","sai","Kumar","pullakandam","xyz@gmail.com","1234",role1,"saii");
		 when(service.deleteAdmin("1")).thenReturn("Deleted");
		 assertEquals("Deleted",controller.delete("1"));
	}
	
}
