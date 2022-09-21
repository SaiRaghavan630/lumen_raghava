package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.MobilePlan;
import com.example.demo.services.MobilePlanService;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="/api/v1/mobileplans")
@AllArgsConstructor
public class MobilePlanController {
	
	private MobilePlanService service;
	
	@GetMapping
	public List<MobilePlan>getAll(){
		return this.service.findAll();
	}
	
	@PostMapping
	public ResponseEntity<MobilePlan> add(@RequestBody MobilePlan entity){
		
		MobilePlan addedObj=this.service.add(entity);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build().toUri();
		
		return ResponseEntity.created(location).body(addedObj);
				
		
	}
	
	@GetMapping("/srch/{id}")
	public MobilePlan findById(@PathVariable("id")int id){
		return this.service.findById(id);
	}
	
	@PutMapping
	public ResponseEntity<MobilePlan> update(@RequestBody MobilePlan entity){
		
	this.service.update(entity);
		return ResponseEntity.ok().body(null);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<MobilePlan> remove(@PathVariable("id")int id){
		
		MobilePlan entity=this.service.remove(id);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	

}
	
	
	@GetMapping("/srch/plan/{name}")
	public List<MobilePlan> findByPlanName(@PathVariable("name")String name){
		return this.service.findByPlanName(name);
	}
	
	
	@GetMapping("/srch/cost/{amount}")
	public List<MobilePlan> getCostGrtThan(@PathVariable("amount")double amount){
		return this.service.getCostGrtThan(amount);
	}
	
	@PatchMapping("/{planName}/{updatedValue}")
    public ResponseEntity<String> updateValidity(@PathVariable("planName") String plan, @PathVariable("updatedValue") String validity){
        
        int updatedRows = this.service.updateDescription(validity, plan);
        return ResponseEntity.status(HttpStatus.OK).body("plan Validity is updated");
    }

	
	
	}
