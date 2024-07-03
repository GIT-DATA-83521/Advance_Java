package com.sunbeam.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//Request:JSON payload containing reservation details (guest name, check-in date, check-out date, room ID).
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
	private String firstName;
	//private Long guestId;

	private LocalDate checkInDate;

	private LocalDate checkOutDate;

	private Long roomId;

}
