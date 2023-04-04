package com.insure.myteam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insure.myteam.entity.Claim;

public interface ClaimRepository extends JpaRepository<Claim,Integer>{
	List<Claim> findByPolicyId(int policyId);

}
