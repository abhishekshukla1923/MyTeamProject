package com.insure.myteam.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insure.myteam.Dto.ClaimDto;
import com.insure.myteam.entity.Claim;
import com.insure.myteam.entity.InsurencePolicy;
import com.insure.myteam.error.ClaimNotFoundException;
import com.insure.myteam.repository.ClaimRepository;
import com.insure.myteam.repository.InsurenceRepository;

@Service
public class ClaimServiceImpl implements ClaimService{
	@Autowired
	private ClaimRepository claimRepository;
	@Autowired
	private InsurenceRepository insurencePolicyRepository;

	@Override
	public void saveClaim(ClaimDto claimDto) {
		// TODO Auto-generated method stub
		Claim claim = convertEntity(claimDto);
		InsurencePolicy insurencePolicy = insurencePolicyRepository.findById(claimDto.getPolicyId()).orElse(null);
		//insurencePolicy.setClient();
		claim.setPolicy(insurencePolicy);
		 claimRepository.save(claim);
	}
	public Claim convertEntity(ClaimDto claimDto) {
		Claim claim = new Claim();
		claim.setDescription(claimDto.getDescription());
		claim.setClaimNumber(claimDto.getClaimNumber());
		claim.setClaimDate(claimDto.getClaimDate());
		claim.setClaimStatus(claimDto.getClaimStatus());
		
		return claim;		
		
	}
	private ClaimDto convertToDto(Claim claim)  {
		ClaimDto claimDto = new ClaimDto();
		claimDto.setId(claim.getId());
		claimDto.setClaimNumber(claim.getClaimNumber());
		claimDto.setDescription(claim.getDescription());
		claimDto.setClaimDate(claim.getClaimDate());
		claimDto.setClaimStatus(claim.getClaimStatus());
		claimDto.setPolicyId(claim.getPolicy().getId());
		return claimDto;
		
	
		
		
	}
	
	@Override
	public List<ClaimDto> findAllclaim() {
		// TODO Auto-generated method stub
		List<Claim> claim = claimRepository.findAll();
		return claim.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	@Override
	public List<Claim> findByPolicyId(int policyId) {
		// TODO Auto-generated method stub
		return claimRepository.findByPolicyId(policyId);
	}
	@Override
	public void deleteById(int id) throws ClaimNotFoundException {
		// TODO Auto-generated method stub
		Optional<Claim> claim = claimRepository.findById(id);
		if(!claim.isPresent()) {
			throw new ClaimNotFoundException("Claim Not Found");
			
		}
		 claimRepository.deleteById(id);;
	}
	@Override
	public void updateByClaim(int id, ClaimDto claimDto) throws ClaimNotFoundException {
		Optional<Claim> claim = claimRepository.findById(id);
		if(!claim.isPresent()) {
			throw new ClaimNotFoundException("Claim Not Found");

		}
		else {
			
			Claim claim1 = claim.get();
		
		if (Objects.nonNull(claimDto.getDescription()) && !"".equalsIgnoreCase(claimDto.getDescription())) {
			
			
			claim1.setDescription(claimDto.getDescription());
		}
		
		
		
if (Objects.nonNull(claimDto.getClaimNumber()) && !"".equalsIgnoreCase(claimDto.getClaimNumber())) {
			
			
	claim1.setClaimNumber(claimDto.getClaimNumber());
}



if (Objects.nonNull(claimDto.getClaimStatus()) && !"".equalsIgnoreCase(claimDto.getClaimStatus())) {
	
	
	claim1.setClaimStatus(claimDto.getClaimStatus());
	}



if (Objects.nonNull(claimDto.getClaimDate())) {
	
	
	//claimDto.setDescription(claim.getClaimDate());
	claim1.setClaimDate(claimDto.getClaimDate());
}
claimRepository.save(claim1);

		
	}
	}
	@Override
	public Claim findByiId(int id) throws ClaimNotFoundException {
		Optional<Claim> claims  = claimRepository.findById(id);
		if(!claims.isPresent()) {
			throw new ClaimNotFoundException("Claim Not Found");
			
		}
		
				return claims.get();
	}
	

}
