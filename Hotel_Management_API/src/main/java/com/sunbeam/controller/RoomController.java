package com.sunbeam.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.RoomRequestDto;
import com.sunbeam.entities.Room;
import com.sunbeam.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<ApiResponse> addNewRoom(@RequestBody RoomRequestDto roomRequestDto) {
        ApiResponse response = roomService.addnewRoom(roomRequestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/available/{checkInDate}")
    public ResponseEntity<?> getListOfAvailableRooms(
    		@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkInDate) {
        try {
           // List<Room> availableRooms = roomService.availableRooms(checkInDate);
            return ResponseEntity.ok(roomService.availableRooms(checkInDate));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
        }
    }
}
