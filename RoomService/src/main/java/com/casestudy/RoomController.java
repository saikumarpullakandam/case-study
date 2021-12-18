package com.casestudy;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RoomController {
	@Autowired
	private RoomRepository roomrepository;
	
	@PostMapping("/addRoom")
	public String saveRoom(@RequestBody Room room) {
		roomrepository.save(room);
		return "Room Added with id :  " + room.getId();
    }
	@GetMapping("/findAllRooms")
	public List<Room> getRooms(){
		return roomrepository.findAll();
		
	}
	
	@GetMapping("/{id}")
	public Optional<Room> getRoom(@PathVariable String id){
		return roomrepository.findById(id);
	}
	
	@PutMapping("/update/{id}")
	public Room updateRoom(@PathVariable("id") String id,@RequestBody Room room ) {
		room.setId(id);
		roomrepository.save(room);
		return room;
	}
		
	 @DeleteMapping("/delete/{id}")
	 public String deleteRoom (@PathVariable String id) {
		 roomrepository.deleteById(id);
		 return "Room deleted with id : "+id;
	}
	


}
