package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.Vehicle;
import com.example.demo.layer4.VehicleServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/vehicle")
public class VehicleJPAController {

	public VehicleJPAController() {
		System.out.println("In Layer 5 Vehicle Controller");
	}

	
	@Autowired
	VehicleServiceImpl vehicleService;
	
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getVehicle/{customerId}")
	public List<Vehicle> getVehicleByCustomerId(@PathVariable int customerId){
		System.out.println("in getVehicleByCustomerId() ... method");
		return vehicleService.selectVehicleByCustomerIdService(customerId);
	}
	
	@PostMapping
	@ResponseBody
	@RequestMapping(value = "/addVehicle")
	public void addVehicle(@RequestBody Vehicle vehicle) {
		System.out.println(vehicle.getVehicleModel());
		vehicleService.insertVehicleService(vehicle);
	 }
	
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getRegisteredVehicle/{registrationNumber}")
	public boolean findVehicleByRegistrationNumber(@PathVariable String registrationNumber){
		System.out.println("in findVehicleByRegsitartionNumberService() ... method");
		return vehicleService.findVehicleByRegsitartionNumberService(registrationNumber);
	}
	
	@PutMapping
	@ResponseBody
	@RequestMapping(value = "/updateVehicle", method = RequestMethod.PUT)
	public void updateVehicle(@RequestBody Vehicle vehicle) {
		System.out.println(vehicle.getVehicleModel());
		vehicleService.updateVehicleService(vehicle);
		System.out.println("vehicle Updated");
	 }
	
}
