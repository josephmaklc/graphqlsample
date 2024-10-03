package com.optimal.solutions.graphqlsample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.optimal.solutions.graphqlsample.dao.entity.Vehicle;
import com.optimal.solutions.graphqlsample.dao.service.VehicleService;

@Controller
public class ResolverController {

	@Autowired
	private VehicleService vehicleService;

	@MutationMapping
	public Vehicle createVehicle(@Argument String type, @Argument String modelCode, @Argument String brandName,
			@Argument String launchDate) {
		System.out.println(
				"inside resolver createVehicle: " + type + " " + modelCode + " " + brandName + " " + launchDate);
		return this.vehicleService.createVehicle(type, modelCode, brandName, launchDate);
	}

	@QueryMapping
	public List<Vehicle> vehicles(@Argument int count) {
		System.out.println("inside resolver get vehicles, count: " + count);

		return this.vehicleService.getAllVehicles(count);
	}

	@QueryMapping
	public Optional<Vehicle> vehicle(@Argument int id) {
		System.out.println("inside resolver getVehicle: " + id);

		return this.vehicleService.getVehicle(id);
	}
}