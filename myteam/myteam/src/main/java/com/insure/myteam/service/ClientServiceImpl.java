package com.insure.myteam.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.insure.myteam.entity.Clients;
import com.insure.myteam.error.ClientNotFoundException;
import com.insure.myteam.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
@Autowired 
private ClientRepository clientrepo;
	@Override
	public Clients saveClient(Clients client) {
				return clientrepo.save(client) ;
	}
	@Override
	public List<Clients> findAllClients() {
		// TODO Auto-generated method stub
		return clientrepo.findAll();
	}
	@Override
	public Clients findById(int id) throws ClientNotFoundException {
		// TODO Auto-generated method stub
		Optional<Clients> clients = clientrepo.findById(id);
		if(! clients.isPresent()) {
			throw new ClientNotFoundException("Client not found");
		}
		return clients.get();
				//clientrepo.findById(id).get();
	}
	@Override
	public void deleteById(int id) throws ClientNotFoundException {
		// TODO Auto-generated method stub
		Optional<Clients> client = clientrepo.findById(id);
		if(! client.isPresent()) {
			throw new ClientNotFoundException("Client not found");
		}
		
		 clientrepo.deleteById(id);
		
	}

	@Override
	public Clients updateById(int id, Clients clients) throws ClientNotFoundException {
		// TODO Auto-generated method stub
		Optional<Clients> client = clientrepo.findById(id);
		if(! client.isPresent()) {
			throw new ClientNotFoundException("client not found");
		}else {
		
			Clients clients1 = client.get();
			
		
		
		System.out.println(clients1);
		if (Objects.nonNull(clients.getName()) && !"".equalsIgnoreCase(clients.getName())) {
			
			clients1.setName(clients.getName());
	     	}
		



if (Objects.nonNull(clients.getAddress()) && !"".equalsIgnoreCase(clients.getAddress())) {
	clients1.setAddress(clients.getAddress());
	
	
 	}


if (Objects.nonNull(clients.getContactInformation()) && !"".equalsIgnoreCase(clients.getContactInformation())) {
	clients1.setContactInformation(clients.getContactInformation());
	
 	}

if (Objects.nonNull(clients.getDateOfBirth())) {
	clients1.setDateOfBirth(clients.getDateOfBirth());
	
 	}
		
		
return clientrepo.save(clients1);
	}
	}
	
	
		
	

}
