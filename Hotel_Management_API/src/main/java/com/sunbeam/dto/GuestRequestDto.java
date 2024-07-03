package com.sunbeam.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GuestRequestDto {
	@NotEmpty(message = "first name should not be empty..!")
	private String firstName;
	private String lastName;
	private Date dob;
}
