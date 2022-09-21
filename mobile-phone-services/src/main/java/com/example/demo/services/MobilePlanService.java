package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.MobilePlan;
import com.example.demo.repo.PlanRepository;

@Service
public class MobilePlanService {

	private PlanRepository repo;
	
	@Autowired
	public MobilePlanService(PlanRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<MobilePlan>findAll(){
		return this.repo.findAll();
	}
	public MobilePlan add(MobilePlan entity) {
		return this.repo.save(entity);
	}
	
	public MobilePlan findById(int id) {
		
		String message=new StringBuilder("Element With Given Id ").append(id).append(" Not Found").toString();
		
		return this.repo.findById(id).orElseThrow(()-> new RuntimeException(message) );
	}

	public MobilePlan update(MobilePlan entity) {
		return this.repo.save(entity);
		
		
	}

	public MobilePlan remove(int id) {
		MobilePlan plan=this.findById(id);
		 this.repo.deleteById(id);
		 return plan;

		
	}

	public List<MobilePlan> findByPlanName(String name) {
		
		return this.repo.findByPlanName(name);
	}

	public List<MobilePlan> getCostGrtThan(double cost) {
	
		return this.repo.getCostGrtThan(cost);
	}

	public int updateDescription(String updateValue, String planName) {
		
		return this.repo.updateDescription(updateValue, planName);
	}
	

}
