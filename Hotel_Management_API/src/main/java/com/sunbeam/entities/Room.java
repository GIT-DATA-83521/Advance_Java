package com.sunbeam.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Rooms")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Room extends BaseEntity{
	
	 

	@Column(length = 20,name="Room_Number")
	private int roomNumber;
	@Enumerated
	private RoomType type;
	private double price;
	private boolean availability;
}
