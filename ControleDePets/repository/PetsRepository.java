package ControleDePets.repository;

import ControleDePets.entities.Pets;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetsRepository extends JpaRepository<Pets, Long>{

}
