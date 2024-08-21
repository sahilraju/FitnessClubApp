package com.example.FitnessClubApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FitnessClubApp.entity.Subscriber;

@Repository 
public interface SubscriberRepository  extends JpaRepository<Subscriber, Long>{

}
 