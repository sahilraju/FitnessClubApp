package com.example.FitnessClubApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FitnessClubApp.entity.SubscriptionPlan;
import com.example.FitnessClubApp.service.SubscriptionPlanService;

@RestController
@RequestMapping("/subscriptionplan")
public class SubscriptionPlanController {
	
	@Autowired
	private SubscriptionPlanService subscriptionPlanService;
	
	@PostMapping("/add")
	ResponseEntity<SubscriptionPlan> addSubscriptionPlan(@RequestBody SubscriptionPlan subscriptionPlan) {
		
		SubscriptionPlan sp = subscriptionPlanService.addSubscriptionPlan(subscriptionPlan);
		
		if(sp != null)
			return ResponseEntity.status(HttpStatus.OK).body(sp);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
 		
	}
	
	@GetMapping("/{id}")
	ResponseEntity<SubscriptionPlan> getSubscriptionPlan(@PathVariable long id) {
		
		SubscriptionPlan sp = subscriptionPlanService.getSubscriptionPlan(id);
		
		if(sp != null)
			return ResponseEntity.status(HttpStatus.OK).body(sp);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); 
		
	}
	
	@GetMapping 
	ResponseEntity<List<SubscriptionPlan>> getSubscriptionPlans() {
		
		return ResponseEntity.status(HttpStatus.OK).body(subscriptionPlanService.getSubscriptionPlans()); 
		
	}
	
	@PutMapping("/edit/{id}")
	ResponseEntity<SubscriptionPlan> editSubscriptionPlan(@RequestBody SubscriptionPlan plan, @PathVariable long id) {
		
		SubscriptionPlan sp = subscriptionPlanService.editSubscriptionPlan(plan, id);
		
		if(sp != null)
			return ResponseEntity.status(HttpStatus.OK).body(sp);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
		
	}
	 
	@DeleteMapping("/delete/{id}")
	ResponseEntity<String> deleteSubscriptionPlan(@PathVariable long id) {
		
		boolean isDeleted = subscriptionPlanService.deleteSubscriptionPlan(id);
		
		if(isDeleted)
			return ResponseEntity.status(HttpStatus.OK).body("subscription plan deleted successfully");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("subscription plan not found");  
		
	}
	

}
