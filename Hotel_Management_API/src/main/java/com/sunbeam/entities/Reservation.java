package com.sunbeam.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Reservation ID, guest id, check-in date, check-out date,
//room ID, total price.
@Entity
@Table(name = "Reservations")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Reservation extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "guest_id",nullable = false)
	private Guest guest;
	@Column(name = "Check_In_Date")
	private LocalDate checkInDate;
	@Column(name = "Check_Out_Date")
	private LocalDate checkOutDate;
	@ManyToOne
	@JoinColumn(name = "room_id",nullable = false)
	private Room room;
	@Column(name = "Total_Price")
	private double totalPrice;

}
