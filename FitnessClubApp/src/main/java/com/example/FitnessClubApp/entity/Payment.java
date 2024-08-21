package com.example.FitnessClubApp.entity;

import java.time.LocalDate;

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
@Table(name = "payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String subscriptionName; 

    @ManyToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "subscriber_id", nullable = false)
    private Subscriber subscriber;

	@Column(nullable = false)
	private double amount;
	
	@Column(nullable = false) 
	private LocalDate paymentDate; 

}
