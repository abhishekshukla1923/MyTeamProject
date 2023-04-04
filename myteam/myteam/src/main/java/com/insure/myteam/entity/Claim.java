package com.insure.myteam.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
@Entity
public class Claim {
	
	@Override
	public String toString() {
		return "Claim [id=" + id + ", claimNumber=" + claimNumber + ", description=" + description + ", claimDate="
				+ claimDate + ", claimStatus=" + claimStatus + ", policy=" + policy + "]";
	}

	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Claim(int id, String claimNumber, String description, LocalDate claimDate, String claimStatus,
			InsurencePolicy policy) {
		super();
		this.id = id;
		this.claimNumber = claimNumber;
		this.description = description;
		this.claimDate = claimDate;
		this.claimStatus = claimStatus;
		this.policy = policy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public InsurencePolicy getPolicy() {
		return policy;
	}

	public void setPolicy(InsurencePolicy policy) {
		this.policy = policy;
	}
	
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Please Enter Claim number")
    private String claimNumber;
    @NotNull(message = "Please Enter description")
    
    private String description;
    @NotNull(message = "Please Enter date")

    @DateTimeFormat(pattern = "YYYY-mm-dd")
    private LocalDate claimDate;
    @NotNull(message = "Please Enter Claim status")
    
    private String claimStatus;
    
    @ManyToOne
    @JoinColumn(name = "policy_id" , referencedColumnName= "policy_id")
    private InsurencePolicy policy;

}
