package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "player_table")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq")
	@SequenceGenerator(name = "player_seq", sequenceName = "PLAYER_SEQ", initialValue = 1, allocationSize = 1)
	@Column(name = "player_id")
	private int id;
	
	@NotNull(message = "can't have spaces or empty values")
	@Column(name = "player_name")
	private String name;
	
	@Min(value = 1 , message = "must be >=1")
	@Max(value = 99 , message = "must be < 100")
	@Column(name = "player_number")
	private int number;
	
	@NotNull(message = "can't have spaces or empty values")
	@Column(name = "player_address")
	private String address;

	public Player() {
	}

	public Player(String name, int number, String address) {
		this.name = name;
		this.number = number;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}