package com.maicon.devsuperior.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maicon.devsuperior.workshopmongo.domain.Post;
import com.maicon.devsuperior.workshopmongo.repository.PostRepository;
import com.maicon.devsuperior.workshopmongo.services.exceptions.ObjectNotFoundException;

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

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }
}
