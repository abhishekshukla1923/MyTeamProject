package com.insure.myteam.service;

import java.util.List;

import com.insure.myteam.Dto.ClaimDto;
import com.insure.myteam.entity.Claim;
import com.insure.myteam.error.ClaimNotFoundException;

import jakarta.persistence.Column;

public interface ClaimService {
	public  void saveClaim(ClaimDto claimDto);
	public List<ClaimDto> findAllclaim();
	public List<Claim> findByPolicyId(int policyId);
	public void deleteById(int id) throws ClaimNotFoundException;
	public void updateByClaim(int id ,ClaimDto claimDto ) throws ClaimNotFoundException;
	public Claim findByiId(int id) throws ClaimNotFoundException;			
	

}
