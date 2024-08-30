package com.maicon.devsuperior.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maicon.devsuperior.workshopmongo.domain.User;
import com.maicon.devsuperior.workshopmongo.repository.UserRepository;
import com.maicon.devsuperior.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();        
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        if (!user.isPresent()) {
            throw new ObjectNotFoundException("Object Not Found!");
        }
        return user.get();
    }
}
