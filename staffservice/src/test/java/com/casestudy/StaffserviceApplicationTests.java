package com.casestudy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.casestudy.repo.StaffRepository;
import com.casestudy.service.StaffService;
@RunWith(SpringRunner.class)
@SpringBootTest
class StaffserviceApplicationTests {

	@Autowired
	private StaffService service;
	
	@MockBean
	private StaffRepository staffrepository;


	@Test
	public void getStaffsTest() {
		when(staffrepository.findAll()).thenReturn(Stream
				.of(new Staff("0","shubham","agra","101","10000","24","manager","manager@gmail.com"),new Staff("02","garg","delhi","200","10000","22","dupty manager","dupty@gmail.com")).collect(Collectors.toList()));
		assertEquals(2,service.getStaffs().size());
	}
	
	@Test
	public void saveStaffTest() {
		Staff staff=new Staff("01","saikumar","hyd","100","20000","21","manager","ravi@gmail.com");
		when(staffrepository.save(staff)).thenReturn(staff);
		assertEquals(staff,service.saveStaff(staff));
	}
	
	@Test
	public void deletestaffTest() {
		Staff room=new Staff("01","saikumar","hyd","100","20000","21","manager","ravi@gmail.com");
		service.delete(room);
	}
	

	

}

