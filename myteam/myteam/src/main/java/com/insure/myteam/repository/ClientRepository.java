package com.insure.myteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insure.myteam.entity.Clients;


public interface ClientRepository extends JpaRepository<Clients,Integer> {

}
