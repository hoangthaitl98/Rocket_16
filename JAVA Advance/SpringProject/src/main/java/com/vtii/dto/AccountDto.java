package com.vtii.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vtii.entity.Position.PositionName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter@Setter
public class AccountDto {
	private short id;
	private String email;
	private String username;
	private String fullname;
	private String department;
	private String position;
	@JsonFormat(pattern = "yyyy-mmm-dd")
	private Date createDate;

	public AccountDto(short id, String email, String username, String fullname, String department, String position, Date createDate) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.department = department;
		this.position = position;
		this.createDate = createDate;
	}
}
