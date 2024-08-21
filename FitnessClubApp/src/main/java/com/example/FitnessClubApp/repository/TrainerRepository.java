package com.example.FitnessClubApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FitnessClubApp.entity.Trainer;

@Repository 
public interface TrainerRepository extends JpaRepository<Trainer, Long> {

}
