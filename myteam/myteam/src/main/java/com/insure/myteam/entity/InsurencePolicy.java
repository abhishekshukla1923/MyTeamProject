package com.insure.myteam.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class InsurencePolicy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "policy_id")
	private int id;
	@NotBlank(message = "Please Enter policyNumber")
	private String policyNumber;
	@NotBlank(message =  "Please Enter Type")
    private String type;
	@NotNull(message =  "Please Enter coverageAmount")
		@Digits(integer =3,fraction = 2)
	//@BigDecimalConstraint()
	

    private BigDecimal coverageAmount;
	@NotNull(message =  "Please Enter premium")
		@Digits(integer =3,fraction = 2)
    private BigDecimal premium;
	@NotNull(message =  "Please Enter startDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")

    private LocalDate startDate;
	@NotNull(message =  "Please Enter endDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")

    private LocalDate endDate;

    @Override
	public String toString() {
		return "InsurencePolicy [id=" + id + ", policyNumber=" + policyNumber + ", type=" + type + ", coverageAmount="
				+ coverageAmount + ", premium=" + premium + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", client=" + client + "]";
	}

	public InsurencePolicy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsurencePolicy(int id, String policyNumber, String type, BigDecimal coverageAmount, BigDecimal premium,
			LocalDate startDate, LocalDate endDate, Clients client) {
		super();
		this.id = id;
		this.policyNumber = policyNumber;
		this.type = type;
		this.coverageAmount = coverageAmount;
		this.premium = premium;
		this.startDate = startDate;
		this.endDate = endDate;
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(BigDecimal coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public BigDecimal getPremium() {
		return premium;
	}

	public void setPremium(BigDecimal premium) {
		this.premium = premium;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

	@ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName= "client_id")
	//@NotBlank(message = "Please Enter Client Id")
    private Clients client;

}
