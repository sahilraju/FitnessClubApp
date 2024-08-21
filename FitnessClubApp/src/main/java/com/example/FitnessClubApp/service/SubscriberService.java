package com.example.FitnessClubApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FitnessClubApp.entity.Subscriber;
import com.example.FitnessClubApp.repository.SubscriberRepository;

@Service
public class SubscriberService {

	@Autowired
	private SubscriberRepository subscriberRepository;

	public void addSubscriber(Subscriber subscriber) {
		
		System.out.println("hello subscriber in controller");
		subscriberRepository.save(subscriber);

	}

}
