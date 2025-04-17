package ControleDePets.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ControleDePets.entities.Pets;
import ControleDePets.repository.PetsRepository;

@Service
public class PetsService {
	private final PetsRepository petsRepository;
	
	public PetsService (PetsRepository petsRepository) {
		this.petsRepository = petsRepository;
	}
	
	public Pets savePet (Pets pets) {
		return petsRepository.save(pets);
	}
	
	public Pets getPetById (Long id) {
		return petsRepository.findById(id).orElse(null);
	}
	
	public List<Pets>getPetAll(){
		return petsRepository.findAll();
	}
	
	public Pets alterarPet(Long id, Pets alterarPet) {
		Optional<Pets> existePet = petsRepository.findById(id);
		if(existePet.isPresent()) {
			alterarPet.setId(id);
			return petsRepository.save(alterarPet);
		}
		else {
			return null;
		}
	}
	
	public boolean deletePet(Long id) {
		Optional<Pets> existePet = petsRepository.findById(id);
		if(existePet.isPresent()) {
			petsRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
}
