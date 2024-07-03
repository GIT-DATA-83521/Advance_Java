package com.sunbeam.service;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.ReservationDto;

public interface ReservationService {
	ApiResponse makeReservation(ReservationDto dto);
	public ApiResponse cancelReservation(Long Id);
}
