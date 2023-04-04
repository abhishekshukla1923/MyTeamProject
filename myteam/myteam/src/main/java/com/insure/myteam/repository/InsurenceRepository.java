package com.insure.myteam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insure.myteam.entity.InsurencePolicy;



public interface InsurenceRepository extends JpaRepository<InsurencePolicy,Integer> {
	List<InsurencePolicy> findByClientId(int clientId );

}
