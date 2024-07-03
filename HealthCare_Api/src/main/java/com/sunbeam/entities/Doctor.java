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
public class Doctor extends BaseEntity{
	@Column(length = 25, name = "First_Name")
	private String firstName;
	@Column(length = 25, name = "Last_Name")
	private String lastName;

	private String specialization;
	

}
