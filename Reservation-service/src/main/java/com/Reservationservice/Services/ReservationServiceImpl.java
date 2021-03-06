package com.Reservationservice.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import com.Reservationservice.Repository.ReservationRepo;
import com.hotel.Reservationservice.Models.Reservation;
import com.hotel.Reservationservice.Models.ReservationList;
import com.hotel.Reservationservice.Models.Room;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationRepo repo;
	
	@Autowired
	private RestTemplate restTmp;
	@CrossOrigin ("http://localhost:4200")
	@Override
	public String bookRoom(Reservation res) {
		Room room= restTmp.getForObject("http://localhost:8006/room-service/Room/getRoom/"+res.getRoomId(), Room.class);
		if(room.isAvailable()) {
			repo.save(res);
			room.setAvailable(false);
			restTmp.put("http://localhost:8006/room-service/Room/updateRoom", room);
			return "Room Number "+room.getRoomNum()+" booked for Customer : "+res.getCustId();
		}
		else {
			return "Room Already Booked!!";
		}
		 
	}

	@Override
	public ReservationList getReservations() {
		ReservationList list=new ReservationList();
		list.setResList(repo.findAll());
		return list; 
	}

	@Override
	public Reservation updateRes(Reservation res) {
		return repo.save(res);
	}
	@CrossOrigin ("http://localhost:4200")
	@Override
	public String deleteRes(int id) {
		Optional<Reservation> res=repo.findById(id);
		Reservation res1=res.get();
		Room room= restTmp.getForObject("http://localhost:8006/room-service/Room/getRoom/"+res1.getRoomId(), Room.class);
		room.setAvailable(true);
		restTmp.put("http://localhost:8006/room-service/Room/updateRoom", room);
		repo.deleteById(id);
		return "Deleted Reservation ID : "+id;
	}

}
