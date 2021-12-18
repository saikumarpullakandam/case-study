package com.casestudy;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
 

@Document(collection="rooms")
public class Room {
	@Id
	private String id;
	private String roomno;
	private String type;
	private String price;
		
	public Room() {
		
	}
	public Room(String id, String roomno, String type, String price) {
		this.id = id;
		this.roomno = roomno;
		this.type = type;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoomno() {
		return roomno;
	}
	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", roomno=" + roomno + ", type=" + type + ", price=" + price + "]";
	}
	
	

}
