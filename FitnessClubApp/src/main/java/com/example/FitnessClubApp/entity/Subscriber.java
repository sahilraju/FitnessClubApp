package com.example.FitnessClubApp.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "subscribers")
public class Subscriber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@Column(nullable = false) 
	private String name;
	
	@Column(nullable = false)
	private int age;
	
	@Column(nullable = false) 
	private double weight;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "trainer_id", nullable = false)
	private Trainer trainer; 
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subscription_plan_id", nullable = false) 
	private SubscriptionPlan subscriptionPlan;

}
