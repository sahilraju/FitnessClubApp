package com.example.FitnessClubApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FitnessClubApp.entity.Subscriber;
import com.example.FitnessClubApp.service.SubscriberService;

@RestController
@RequestMapping("/subscriber")
public class SubscriberController {
	
	@Autowired 
	private SubscriberService subscriberService;
	
	@PostMapping("/save")
	public void addSubscriber(@RequestBody Subscriber subscriber) {
		
		System.out.println("hello subscriber in controller");
		subscriberService.addSubscriber(subscriber); 
		
	} 
 
}
