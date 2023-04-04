package com.insure.myteam.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insure.myteam.Dto.InsurencePolicyDto;
import com.insure.myteam.entity.Clients;
import com.insure.myteam.entity.InsurencePolicy;
import com.insure.myteam.error.ClientNotFoundException;
import com.insure.myteam.error.InsurencePolicyNotFoundException;
import com.insure.myteam.repository.ClientRepository;
import com.insure.myteam.repository.InsurenceRepository;
@Service
public class InsurencePolicyServiceImpl implements InsurencePolicyService {
	@Autowired
	private InsurenceRepository insurenceRepository;
	@Autowired 
	private ClientRepository clientrepo;
	@Override
	public void saveInsurancePolicy(InsurencePolicyDto insurancePolicydto) {
		InsurencePolicy insurencePolicy = convertToEntity(insurancePolicydto);
		Clients clients = clientrepo.findById(insurancePolicydto.getClientId()).orElse(null);
		insurencePolicy.setClient(clients);
		insurenceRepository.save(insurencePolicy);
		}
	
	
	private InsurencePolicy convertToEntity(InsurencePolicyDto nsurencePolicyDto) {
		InsurencePolicy insurencePolicy = new InsurencePolicy();
		insurencePolicy.setCoverageAmount(nsurencePolicyDto.getCoverageAmount());
		insurencePolicy.setPolicyNumber(nsurencePolicyDto.getPolicyNumber());	
		insurencePolicy.setPremium(nsurencePolicyDto.getPremium());
		insurencePolicy.setType(nsurencePolicyDto.getType());
		insurencePolicy.setStartDate(nsurencePolicyDto.getStartDate());
		insurencePolicy.setEndDate(nsurencePolicyDto.getEndDate());
		return insurencePolicy;
	}
	private InsurencePolicyDto convertToDto(InsurencePolicy insurencePolicy){
		InsurencePolicyDto insurencePolicyDto = new InsurencePolicyDto();
		
		insurencePolicyDto.setCoverageAmount(insurencePolicy.getCoverageAmount());
		insurencePolicyDto.setPolicyNumber(insurencePolicy.getPolicyNumber());
		insurencePolicyDto.setId(insurencePolicy.getId());
		
		insurencePolicyDto.setStartDate(insurencePolicy.getStartDate());
		insurencePolicyDto.setEndDate(insurencePolicy.getEndDate());
		insurencePolicyDto.setPremium(insurencePolicy.getPremium());
		insurencePolicyDto.setType(insurencePolicy.getType());
		
		
		insurencePolicyDto.setClientId(insurencePolicy.getClient().getId());
		//System.out.println(insurencePolicy.getClient());
		return insurencePolicyDto;
		
	}


	@Override
	public List<InsurencePolicyDto> findInsurencePolicy() {
		// TODO Auto-generated method stub
		List<InsurencePolicy> insurencePolicy1 = insurenceRepository.findAll();
		
						
		return insurencePolicy1.stream().map(this::convertToDto).collect(Collectors.toList());
	}


	@Override
	public List<InsurencePolicy> findByClientId(int clientId) {
		// TODO Auto-generated method stub
		//Optional<InsurencePolicy> insurencePolicy = insurenceRepository.findByClientId(clientId);
				return insurenceRepository.findByClientId(clientId) ;
	}


	@Override
	public InsurencePolicy findById(int id) throws InsurencePolicyNotFoundException {
		// TODO Auto-generated method stub
		Optional<InsurencePolicy> insurencePolicy = insurenceRepository.findById(id) ;
		if(! insurencePolicy.isPresent()) {
			throw new InsurencePolicyNotFoundException("InsurencePolicy not found ");
		}
		
		System.out.println(insurencePolicy);
		//return (InsurencePolicyDto) insurencePolicy.stream().map(this::convertToDto).collect(Collectors.toList());
			return insurencePolicy.get();
		
	}


	@Override
	public void deleteById(int id) throws InsurencePolicyNotFoundException {
		// TODO Auto-generated method stub
		Optional<InsurencePolicy> insurencePolicy = insurenceRepository.findById(id) ;
		if(! insurencePolicy.isPresent()) {
			throw new InsurencePolicyNotFoundException("InsurencePolicy not found ");
		}
		insurenceRepository.deleteById(id);
		
		
	}


	@Override
	public void UpdateById(int id ,InsurencePolicyDto insurence) throws InsurencePolicyNotFoundException {
		// TODO Auto-generated method stub
		//clientrepo.findById()
		
		Optional <InsurencePolicy> insurencepolicy = insurenceRepository.findById(id);
		if(!insurencepolicy.isPresent()) {
			throw new InsurencePolicyNotFoundException("InsurencePolicy not found ");

		}
		else {
			InsurencePolicy insurencepolicy1 = insurencepolicy.get();
		
		
if (Objects.nonNull(insurence.getPolicyNumber()) && !"".equalsIgnoreCase(insurence.getPolicyNumber())) {
			
	insurencepolicy1.setPolicyNumber(insurence.getPolicyNumber());
	     	}


if (Objects.nonNull(insurence.getType()) && !"".equalsIgnoreCase(insurence.getType())) {
	
	insurencepolicy1.setType(insurence.getType());
}

if (Objects.nonNull(insurence.getCoverageAmount())) {
	
	insurencepolicy1.setCoverageAmount(insurence.getCoverageAmount());
}

if (Objects.nonNull(insurence.getPremium())) {
	
	insurencepolicy1.setPremium(insurence.getPremium());
}

if (Objects.nonNull(insurence.getStartDate())) {
	
	insurencepolicy1.setStartDate(insurence.getStartDate());
}
if (Objects.nonNull(insurence.getEndDate())) {
	
	insurencepolicy1.setEndDate(insurence.getEndDate());
}





		 insurenceRepository.save(insurencepolicy1) ;
		}
	}
	
	
	
}
	

	
