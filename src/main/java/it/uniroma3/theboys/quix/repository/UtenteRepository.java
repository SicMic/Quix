package it.uniroma3.theboys.quix.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.theboys.quix.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
    
}
