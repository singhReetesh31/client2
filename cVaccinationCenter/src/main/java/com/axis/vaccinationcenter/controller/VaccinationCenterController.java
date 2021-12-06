package com.axis.vaccinationcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.axis.vaccinationcenter.dao.IVaccinationCenterDao;
import com.axis.vaccinationcenter.entity.VaccinationCenter;
import com.axis.vaccinationcenter.feignclient.IFeignClient;
import com.axis.vaccinationcenter.model.Citizen;
import com.axis.vaccinationcenter.model.Response;

import java.util.List;

@RestController
@RequestMapping("/vaccinationCenter")

public class VaccinationCenterController {
	
	@Autowired
	IVaccinationCenterDao dao;
	//@Autowired
	//RestTemplate restTemplate;
	@Autowired
	IFeignClient feignClient;
	
	
@PostMapping("/add")
public ResponseEntity<Object> add(@RequestBody VaccinationCenter center){
	dao.save(center);
	return new ResponseEntity<Object>(HttpStatus.OK);
}
@GetMapping("/id/{id}")
public ResponseEntity<Response> getResponse(@PathVariable int id){
	//get center by id
	//get all citizens associated with that center
	VaccinationCenter center=dao.findById(id).get();
	Response response=new Response();
	response.setCenter(center);
	//List<Citizen> citizens=restTemplate.getForObject("http://localhost:8081/citizen/id/"+id, List.class);
	//List<Citizen> citizens=restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);
	List<Citizen> citizens=feignClient.getCitizenFromCitizenService(id);
	response.setCitizens(citizens);
	return new ResponseEntity<Response>(response,HttpStatus.OK);
}
}
