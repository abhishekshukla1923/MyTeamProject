package com.insure.myteam.service;

import java.util.List;

import com.insure.myteam.Dto.InsurencePolicyDto;
import com.insure.myteam.entity.InsurencePolicy;
import com.insure.myteam.error.InsurencePolicyNotFoundException;


public interface InsurencePolicyService {

public void saveInsurancePolicy(InsurencePolicyDto insurancePolicy) ;

public List<InsurencePolicyDto> findInsurencePolicy();
public List<InsurencePolicy> findByClientId(int clientId);
public InsurencePolicy findById(int id) throws InsurencePolicyNotFoundException;
public void deleteById(int id) throws InsurencePolicyNotFoundException;
public void UpdateById(int id ,InsurencePolicyDto insurence) throws InsurencePolicyNotFoundException;
	
	
}

