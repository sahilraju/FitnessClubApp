package com.example.FitnessClubApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FitnessClubApp.entity.SubscriptionPlan;

@Repository 
public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Long> { 

}
