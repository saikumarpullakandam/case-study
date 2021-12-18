package com.casestudy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomServiceApplicationTests {

	@Autowired
	private RoomService service;
	
	@MockBean
	private RoomRepository roomrepository;
	
	@Test
	public void getRoomsTest() {
		when(roomrepository.findAll()).thenReturn(Stream
				.of(new Room("9","109","single bed","1000"),new Room("10","110","double bed","1500")).collect(Collectors.toList()));
		assertEquals(2,service.getRooms().size());
	}
	
	@Test
	public void saveRoomTest() {
		Room room=new Room("11","111","single bed","1000");
		when(roomrepository.save(room)).thenReturn(room);
		assertEquals(room,service.addRoom(room));
	}
	
	@Test
	public void deleteRoomTest() {
		Room room=new Room("11","111","single bed","1000");
		service.deleteRoom(room);
	}
	

	

}
