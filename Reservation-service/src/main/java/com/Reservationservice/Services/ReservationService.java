package com.Reservationservice.Services;

import com.Reservationservice.Models.Reservation;
import com.Reservationservice.Models.ReservationList;

public interface ReservationService {

	String bookRoom(Reservation res);

	ReservationList getReservations();

	Reservation updateRes(Reservation res);

	String deleteRes(int id);

}
