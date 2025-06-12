package com.MainProject.FlightBooking.Repository;

import com.MainProject.FlightBooking.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
