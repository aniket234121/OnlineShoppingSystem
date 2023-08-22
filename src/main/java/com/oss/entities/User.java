package com.oss.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	@Column(length=30)
	private String user_name;
	@Column(length=30)
	private String user_email;
	@Column(length=10)
	private String user_role;
	@Column(length=15)
	private String user_password;
	@Column(length=100)
	private String user_address;
}
