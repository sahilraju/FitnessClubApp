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

import com.example.FitnessClubApp.entity.Trainer;
import com.example.FitnessClubApp.service.TrainerService;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
	
	@Autowired
	private TrainerService trainerService;
	
	@PostMapping("/add") 
	ResponseEntity<Trainer> addTrainer(@RequestBody Trainer trainer) {
		
		Trainer tr = trainerService.addTrainer(trainer);
		
		if(tr != null)
			return ResponseEntity.status(HttpStatus.OK).body(tr);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  
		
	}
	
	@GetMapping("/{id}")
	ResponseEntity<Trainer> getTrainer(@PathVariable long id) {
		
		Trainer trainer = trainerService.getTrainer(id);
		
		if(trainer != null) 
			return ResponseEntity.status(HttpStatus.OK).body(trainer); 
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 		
		
	}
	
	@GetMapping
	ResponseEntity<List<Trainer>> getTrainers() {
		
		return ResponseEntity.status(HttpStatus.OK).body(trainerService.getTrainers()); 	
		
	}
	
	@PutMapping("/edit/{id}")
    ResponseEntity<Trainer> editTrainer(@RequestBody Trainer trainer, @PathVariable long id) {
		
		Trainer tr = trainerService.editTrainer(trainer, id);
		
		if(tr != null)
			return ResponseEntity.status(HttpStatus.OK).body(tr);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
		
	} 
	
	@DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteTrainer(@PathVariable long id) {
		
		boolean isDeleted = trainerService.deleteTrainer(id);
		
		if(isDeleted)
			return ResponseEntity.status(HttpStatus.OK).body("trainer deleted successfully");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("trainer not found"); 
		
	}
	 

}
