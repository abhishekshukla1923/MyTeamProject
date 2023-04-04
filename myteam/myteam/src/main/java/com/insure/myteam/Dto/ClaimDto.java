package com.insure.myteam.Dto;

import java.time.LocalDate;


public class ClaimDto {
private int id;
    
    private String claimNumber;
    
    private String description;
    
    private LocalDate claimDate;
    
    @Override
	public String toString() {
		return "ClaimDto [id=" + id + ", claimNumber=" + claimNumber + ", description=" + description + ", claimDate="
				+ claimDate + ", claimStatus=" + claimStatus + ", policyId=" + policyId + "]";
	}
	public ClaimDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClaimDto(int id, String claimNumber, String description, LocalDate claimDate, String claimStatus,
			int policyId) {
		super();
		this.id = id;
		this.claimNumber = claimNumber;
		this.description = description;
		this.claimDate = claimDate;
		this.claimStatus = claimStatus;
		this.policyId = policyId;
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
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	private String claimStatus;
    private int policyId;


}
