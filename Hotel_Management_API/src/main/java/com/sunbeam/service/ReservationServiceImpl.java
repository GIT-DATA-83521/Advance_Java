package com.sunbeam.service;

import java.time.temporal.ChronoUnit;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.Guestdao;
import com.sunbeam.dao.ReservationDao;
import com.sunbeam.dao.RoomDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.ReservationDto;
import com.sunbeam.entities.Guest;
import com.sunbeam.entities.Reservation;
import com.sunbeam.entities.Room;

import net.bytebuddy.asm.Advice.Return;
@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationDao reservationDao;
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private Guestdao guestdao;
	@Autowired
	private ModelMapper mapper;
	@Override
	public ApiResponse makeReservation(ReservationDto dto) {
		Room room = roomDao.findById(dto.getRoomId()).orElseThrow(() -> new ResourceNotFoundException("Invalid Room ID!!!!"));
		Guest guest= guestdao.findByFirstName(dto.getFirstName()).orElseThrow(() -> new ResourceNotFoundException("Invalid First name!!!!"));
		
		Reservation reservation=mapper.map(dto, Reservation.class);
		reservation.setRoom(room);
		reservation.setGuest(guest);
		room.setAvailability(false);
		long days = ChronoUnit.DAYS.between(dto.getCheckInDate(), dto.getCheckOutDate());
		double price = room.getPrice()*days;
		reservation.setTotalPrice(price);
		reservationDao.save(reservation);
		
		
		return new ApiResponse("Reservation done successfully...!");
	}
	public ApiResponse cancelReservation(Long Id) {
		Reservation reservation=reservationDao.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Invalid Reservation ID!!!!"));
		if(reservationDao.existsById(Id)) {
			reservationDao.deleteById(Id);
			reservation.getRoom().setAvailability(true);
			return new ApiResponse("Reservation cancelled successfully");
		}
		return new ApiResponse("Reservation cancelled failed");
		
	}
	

}
