package com.example.FitnessClubApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FitnessClubApp.entity.Trainer;
import com.example.FitnessClubApp.repository.TrainerRepository;

@Service
public class TrainerService {

	@Autowired
	private TrainerRepository trainerRepository;

	public Trainer addTrainer(Trainer trainer) {

		Trainer savedTrainer = trainerRepository.save(trainer);

		return savedTrainer;

	}

	public Trainer getTrainer(long id) {

		Optional<Trainer> opt = trainerRepository.findById(id);

		if (opt.isPresent())
			return opt.get();

		return null;

	}
	
	public List<Trainer> getTrainers() {

		return trainerRepository.findAll();

	}

	public Trainer editTrainer(Trainer trainer, long id) {

		Optional<Trainer> opt = trainerRepository.findById(id);

		if (opt.isPresent()) {

			Trainer tr = opt.get();
			tr.setName(trainer.getName());
			trainerRepository.save(tr); 
			
			return tr;

		}
		
		return null; 

	}
	
	public boolean deleteTrainer(long id) {
		
		Optional<Trainer> opt = trainerRepository.findById(id);
		
		if(opt.isPresent()) {
			 trainerRepository.delete(opt.get()); 
			 return true;
		}
		
		return false; 
		
	}

}
