package com.insure.myteam.service;

import java.util.List;

import com.insure.myteam.entity.Clients;
import com.insure.myteam.error.ClientNotFoundException;

public interface ClientService {
	public Clients saveClient(Clients client);
	List<Clients> findAllClients() ;
	public Clients findById(int id) throws ClientNotFoundException;
	public void deleteById(int id) throws ClientNotFoundException;
	public Clients updateById(int id,Clients clients) throws ClientNotFoundException;

}
