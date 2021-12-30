package com.casestudy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.casestudy.Staff;
import com.casestudy.repo.StaffRepository;


@Service
public abstract class StaffService {
	
	
private StaffRepository staffrepository;
	
	public Staff saveStaff( Staff staff)
	{
		return staffrepository.save(staff);
	}
    public List<Staff> getStaffs()
    {
    List<Staff>staff=staffrepository.findAll();
    return staff;
    }
  public Optional<Staff>getStaffs(String id)
  {
	  return staffrepository.findById(id);
	  
  }
  public void delete(Staff staff)
  {
	  staffrepository.delete(staff);
	  
  }

}
