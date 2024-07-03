package com.sunbeam.service;


import java.time.LocalDate;
import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.RoomRequestDto;
import com.sunbeam.entities.Room;

public interface RoomService {
	public ApiResponse addnewRoom(RoomRequestDto req);
	public List<Room> availableRooms(LocalDate date);

}
