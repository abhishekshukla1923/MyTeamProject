package com.insure.myteam.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Clients {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name = "client_id")
	private int id;
	@NotBlank(message = " please Entry your name")
	
	private String name;
	@NotNull(message = "Please Enter your Date of Birth")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @Override
	public String toString() {
		return "Clients [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address
				+ ", contactInformation=" + contactInformation + "]";
	}
	public Clients() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Clients(int id, String name, LocalDate dateOfBirth, String address, String contactInformation) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.contactInformation = contactInformation;
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
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactInformation() {
		return contactInformation;
	}
	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}
	@NotBlank(message= "Enter the Address")
	private String address;
	@Email(message="Enter your email")
    private String contactInformation;


}
