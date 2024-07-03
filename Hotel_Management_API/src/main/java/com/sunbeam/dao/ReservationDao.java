package com.sunbeam.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunbeam.entities.Reservation;
import com.sunbeam.entities.Room;

public interface ReservationDao extends JpaRepository<Reservation, Long> {
    @Query("SELECT r.room FROM Reservation r WHERE :checkInDate BETWEEN r.checkInDate AND r.checkOutDate")
    List<Room> findReservationsOnDate(@Param("checkInDate") LocalDate checkInDate);
}
