package com.casestudy;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
	@Autowired
	private RoomRepository roomrepository;
	
	public Room addRoom(Room room) {
		return roomrepository.save(room);
		
    }
	
	public List<Room> getRooms(){
		List<Room> rooms=roomrepository.findAll();
		return rooms;
		
	}
	
	
	public Optional<Room> getRoom( String id){
		return roomrepository.findById(id);
	}
		
	 
	 public void deleteRoom (Room room) {
		 roomrepository.delete(room);
		 
	}
	


}
