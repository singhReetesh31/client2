package com.axis.vaccinationcenter.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.axis.vaccinationcenter.model.Citizen;

@FeignClient(url = "http://localhost:8081/citizen",name = "citizen-srvice")
public interface IFeignClient {
@GetMapping("/id/{id}")
public List<Citizen> getCitizenFromCitizenService(@PathVariable int id);
}
