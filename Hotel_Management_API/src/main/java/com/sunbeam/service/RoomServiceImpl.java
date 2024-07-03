package com.sunbeam.service;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.ReservationDao;
import com.sunbeam.dao.RoomDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.RoomRequestDto;
import com.sunbeam.entities.Room;
@Service
@Transactional
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private ReservationDao reservationDao;

	@Override
	public ApiResponse addnewRoom(RoomRequestDto req) {
		Room room = mapper.map(req, Room.class);
		roomDao.save(room);
		
		return new ApiResponse("Room added successfully");
	}

	@Override
	public List<Room> availableRooms(LocalDate date) {
		List<Room> unavailableRoom = reservationDao.findReservationsOnDate(date);
		List<Room> rooms = roomDao.findAll();
		rooms.removeAll(unavailableRoom);
		return rooms;
	}
}
