package com.sunbeam.dto;
import com.sunbeam.entities.RoomType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class RoomRequestDto {
	private int roomNumber;
	private RoomType type;
	private double price;
	private boolean availability;

}
