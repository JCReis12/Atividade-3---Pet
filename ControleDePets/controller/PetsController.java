package ControleDePets.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ControleDePets.entities.Pets;
import ControleDePets.service.PetsService;

@RestController
@RequestMapping("/pet")
public class PetsController {
	private final PetsService petsService;
	
	
	public PetsController (PetsService petsService) {
		this.petsService = petsService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Pets>> getAllPet(){
		List<Pets> pet = petsService.getPetAll();
		return ResponseEntity.ok(pet);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pets>criarPet(@RequestBody Pets pets){
		Pets criarPet = petsService.savePet(pets);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarPet);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Pets> alterarPet(@PathVariable Long id, @RequestBody Pets pets){
		Pets alterarPet = petsService.alterarPet(id, pets);
		if(alterarPet != null) {
			return ResponseEntity.ok(alterarPet);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePet(@PathVariable Long id){
		boolean deleted = petsService.deletePet(id);
		if(deleted) {
			return ResponseEntity.ok().body("Pet excluído com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
