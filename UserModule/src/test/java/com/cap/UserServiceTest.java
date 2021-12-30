package com.cap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.cap.model.Role;
import com.cap.model.User;
import com.cap.repository.RoleRepository;
import com.cap.repository.UserRepository;
import com.cap.service.UserService;

@SpringBootTest(classes = UserServiceTest.class)
public class UserServiceTest {
	
	@Mock
	UserRepository repo;
	
	@Mock
	RoleRepository role;
	
	@InjectMocks
	UserService service;
	
     User user;
     
     @Mock
     PasswordEncoder passwordEncoder;
     
     
     
	
	@Test
	public void TestAddAdmin()
	{
		Set<Role> role1 = new HashSet<Role>();
		role1.add(new Role("1","User"));
		 user = new User ("1","sai","kumar","pullakandam","12345","male","sai@gmail.com","1234","hyd",role1,"saikumar");
     	when(repo.save(user)).thenReturn(user);
        assertEquals(user, service.createUser(user));
 
	}
	

	@Test
	public void TestFindByName()
	{
		Set<Role> role1 = new HashSet<Role>();
		role1.add(new Role("1","User"));
		 user = new User ("1","sai","kumar","pullakandam","12345","male","sai@gmail.com","1234","hyd",role1,"saikumar");
		 when(repo.findByUserName("sai")).thenReturn(user);
		 assertEquals(user,service.findUserName("sai"));
		
	}

	
}
