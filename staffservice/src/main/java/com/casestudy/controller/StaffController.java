 	package com.casestudy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.casestudy.Staff;
import com.casestudy.repo.StaffRepository;

@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private StaffRepository staffrepository;
	
	// add the staff
	@CrossOrigin ("http://localhost:4200")
	@PostMapping(value = "/AddStaff")
	public String saveStaff(@RequestBody Staff staff)
	{
		staffrepository.save(staff);

	return "Added staff with id : " + staff.getId();
	
}

	@CrossOrigin ("http://localhost:4200")
   @GetMapping("/findAllThestaff")
   public List<Staff>getStaffs()
   {
	   return staffrepository.findAll();
	   
   }
   // find the specific customer through there id
	@CrossOrigin ("http://localhost:4200")
   @GetMapping("/findstaff/{id}")
   public Optional<Staff>getStaffs(@PathVariable String id)
   {
	   return staffrepository.findById(id);
   }
   
   //delete the specific staff through there id
   @CrossOrigin ("http://localhost:4200")
   @DeleteMapping("/delete/{id}")
   public String deletestaff(@PathVariable String id)
   {
	   staffrepository.deleteById(id);
	   return "staff have been Deleted with id: "+ id;
   }
   
 
}