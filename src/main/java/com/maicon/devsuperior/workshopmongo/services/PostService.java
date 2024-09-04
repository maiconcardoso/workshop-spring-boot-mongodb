package com.maicon.devsuperior.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maicon.devsuperior.workshopmongo.domain.Post;
import com.maicon.devsuperior.workshopmongo.repository.PostRepository;
import com.maicon.devsuperior.workshopmongo.services.exceptions.ObjectNotFoundException;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Optional<Post> findById(String id) {
        Optional<Post> post = repository.findById(id);
        if (!post.isPresent() || post == null ) {
            throw new ObjectNotFoundException("Object not found!");
        }
        return post;
    }
}
