package com.optimal.solutions.graphqlsample.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.optimal.solutions.graphqlsample.dao.entity.Vehicle;
import com.optimal.solutions.graphqlsample.dao.service.VehicleService;

@RestController
public class TestController {
    
    
    @Autowired
    private VehicleService vehicleService;

    
    @GetMapping("testinsert")
    public String testing() {
    	Vehicle v = vehicleService.createVehicle("SUV","Highlander","Toyota","2024-10-03");
    	return "inserted "+v.toString();
    }

    @GetMapping("testget")
    public String testget(@RequestParam int id) {
    	Optional<Vehicle> v = vehicleService.getVehicle(id);
    	return v.get().toString();
    }

}