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

import com.insure.myteam.Dto.InsurencePolicyDto;
import com.insure.myteam.entity.InsurencePolicy;
import com.insure.myteam.error.InsurencePolicyNotFoundException;
import com.insure.myteam.service.InsurencePolicyService;

import jakarta.validation.Valid;

@RestController
public class InsurencePolicyController {
	@Autowired 
	private InsurencePolicyService insurencePolicyService;
	@PostMapping("/insurencepolicy")
	public void  saveInsurancePolicy(@Valid @RequestBody InsurencePolicyDto insurancePolicydto) {
		  insurencePolicyService.saveInsurancePolicy(insurancePolicydto);
	}
	@GetMapping("/insurencepolicy")
	public List<InsurencePolicyDto> findInsurencePolicy(){
		return insurencePolicyService.findInsurencePolicy();
		
	}
	
	@GetMapping("/insurencepolicyclient/{clientid1}")
	public List<InsurencePolicy> findAllClientId(@PathVariable("clientid1") int clientId){
		return insurencePolicyService.findByClientId(clientId);
	}
	@GetMapping("/insurencepolicy/{id1}")
	public InsurencePolicy findById(@PathVariable("id1") int id) throws InsurencePolicyNotFoundException{
		return insurencePolicyService.findById(id);
	}
	@DeleteMapping("insurencepolicy/{id1}")
	public String deleteById(@PathVariable ("id1") int id) throws InsurencePolicyNotFoundException {
		
		insurencePolicyService.deleteById(id);
		return "Delete Successfully";
	}
	@PutMapping("/insurencepolicy/{id1}")
	public void UpdateById(@PathVariable("id1")int id ,@RequestBody InsurencePolicyDto insurencePolicy ) throws InsurencePolicyNotFoundException {
		 insurencePolicyService.UpdateById(id, insurencePolicy);
	}
	
	
	

}
