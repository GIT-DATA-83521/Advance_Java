package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dao.ReservationDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.ReservationDto;
import com.sunbeam.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	@PostMapping
	public ResponseEntity<?> newReservation(@RequestBody ReservationDto reservationDto){
		ApiResponse response = reservationService.makeReservation(reservationDto);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{reservationId}")
	public ResponseEntity<?> deleteReservation(@PathVariable Long reservationId){
		return ResponseEntity.ok(reservationService.cancelReservation(reservationId));
	}

}
