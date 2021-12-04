package com.casestudy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.casestudy.Admin;
import com.casestudy.Repository.AdminRepository;

@RestController

public class AdminController {
	@Autowired
	private AdminRepository adminrepo;
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/addAdmin")
	public String saveAdmin(@RequestBody Admin admin) {
		adminrepo.save(admin);
		return "Admin added";
    }
	@GetMapping("/findAllAdmin")
	public List<Admin> getAdmin(){
		return adminrepo.findAll();
		
	}
	

}



