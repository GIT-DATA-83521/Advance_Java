package com.sunbeam.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.GuestRequestDto;
import com.sunbeam.service.GuestService;

@RestController
@RequestMapping("/guests")
public class GuestController {
	@Autowired
	private GuestService guestService;
	@PostMapping
	public ResponseEntity<?> addNewGuest(@RequestBody @Valid GuestRequestDto guestRequestDto){ 
		ApiResponse response = guestService.addNewGuest(guestRequestDto);
		return ResponseEntity.ok(response);
	}
	

}
