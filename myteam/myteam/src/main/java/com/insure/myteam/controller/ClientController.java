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


import com.insure.myteam.entity.Clients;
import com.insure.myteam.error.ClientNotFoundException;
import com.insure.myteam.service.ClientService;

import jakarta.validation.Valid;

@RestController
public class ClientController {
	@Autowired 
	ClientService clientService;
	@PostMapping("/client")
	public Clients saveClient(@Valid @RequestBody Clients client) {
		return clientService.saveClient(client);
		
	}
	@GetMapping("/client")
	public List<Clients> findAllClients(){
		return clientService.findAllClients();
	}
	@GetMapping("/client/{id}")
	public Clients findById(@PathVariable("id") int id) throws ClientNotFoundException {
		return clientService.findById(id);
	}
	@DeleteMapping("/client/{id}")
	public String deleteById(@PathVariable("id") int id) throws ClientNotFoundException {
		clientService.deleteById(id);
		return "Successfully Deleted";
				
		
	}
	@PutMapping("/client/{id1}")
	public Clients  updateById(@PathVariable("id1") int id , @RequestBody Clients client) throws ClientNotFoundException {
		
				return clientService.updateById(id, client);
		
		
	}
	

}
