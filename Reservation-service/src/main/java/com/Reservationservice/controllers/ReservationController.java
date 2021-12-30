package com.Reservationservice.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Reservationservice.Services.ReservationService;

import com.hotel.Reservationservice.Models.Reservation;
import com.hotel.Reservationservice.Models.ReservationList;

@RestController
@CrossOrigin ("http://localhost:4200")
@RequestMapping("/Reservation")
public class ReservationController {
	
	@Autowired
	private ReservationService service;
	@CrossOrigin ("http://localhost:4200")
	@PostMapping("/bookRoom")
	public String bookRoom(@RequestBody Reservation res) 
	{
		return this.service.bookRoom(res); 
	}
	@CrossOrigin ("http://localhost:4200")
	@GetMapping("/getReservations")
	public ReservationList getReservation()
	{
		return this.service.getReservations();
	}
	@CrossOrigin ("http://localhost:4200")
	@PutMapping("/updateReservation")
	public Reservation updateReservation(@RequestBody Reservation res)
	{
		return this.service.updateRes(res);
	}
	@CrossOrigin ("http://localhost:4200")
	@DeleteMapping("/deleteReservation/{id}")
	public String deleteReservation(@PathVariable String id)
	{
		return this.service.deleteRes(Integer.parseInt(id));
	}
	
	
	
	
}
	
	
	
	
	