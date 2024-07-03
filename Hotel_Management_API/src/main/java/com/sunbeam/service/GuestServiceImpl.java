package com.sunbeam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.Guestdao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.GuestRequestDto;
import com.sunbeam.entities.Guest;
@Service
@Transactional
public class GuestServiceImpl implements GuestService {
	@Autowired
	private Guestdao guestdao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addNewGuest(GuestRequestDto dto) {
		Guest guest=mapper.map(dto, Guest.class);
		guestdao.save(guest);
		return new ApiResponse("Guest added successfully..!!!");
	}

}
