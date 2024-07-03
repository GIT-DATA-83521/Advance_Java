package com.sunbeam.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends BaseEntity{
	@Column(length = 25, name = "First_Name")
	private String firstName;
	@Column(length = 25, name = "Last_Name")
	private String lastName;

	@Column(name = "Date_Of_Birth")
	private Date dob;
	private String gender;
	@Column(name = "Phone_No")
	private String phoneNo;
}
