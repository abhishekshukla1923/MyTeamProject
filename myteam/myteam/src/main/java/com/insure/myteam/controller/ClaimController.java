package com.insure.myteam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insure.myteam.Dto.ClaimDto;
import com.insure.myteam.Dto.InsurencePolicyDto;
import com.insure.myteam.entity.Claim;
import com.insure.myteam.error.ClaimNotFoundException;
import com.insure.myteam.service.ClaimService;

@RestController
public class ClaimController{
	@Autowired 
	private ClaimService claimService;
	
	@PostMapping("/claim")
	public void saveClaim(@RequestBody ClaimDto claimDto) {
		claimService.saveClaim(claimDto);
		}
	@GetMapping("/claim")
	public List<ClaimDto> findAllclaim(){
		return claimService.findAllclaim();
		
	}
	@GetMapping("/claim1/{policyId}")
	public List<Claim>findAllByPolicyId(@PathVariable ("policyId") int policyId){
		return claimService.findByPolicyId(policyId);
		
	}
	@DeleteMapping("/claim/{id1}")
	public String deleteById( @PathVariable("id1") int id) throws ClaimNotFoundException {
		claimService.deleteById(id);
		return "deleted Successfully";
}
	
	@PutMapping("/claim/{id1}")
	public void updateByClaim(@PathVariable("id1") int id ,@RequestBody ClaimDto claimdto ) throws ClaimNotFoundException {
		 claimService.updateByClaim(id, claimdto);
		
	}
	@GetMapping("/claims/{id}")
	public Claim findByiId( @PathVariable("id")int id ) throws ClaimNotFoundException {
		return claimService.findByiId(id);
	}
	
	
	

}
