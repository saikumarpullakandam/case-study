package com.Reservationservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Reservationservice.Models.Reservation;

public interface ReservationRepo extends MongoRepository<Reservation, Integer> {

}
