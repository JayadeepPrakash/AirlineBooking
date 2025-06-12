package com.MainProject.FlightBooking.Repository;

import com.MainProject.FlightBooking.Entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
   // List<Seat> findByTravelClassId(Integer travelClassId);
}
