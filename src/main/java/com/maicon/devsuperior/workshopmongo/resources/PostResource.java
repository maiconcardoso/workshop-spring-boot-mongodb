package com.maicon.devsuperior.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maicon.devsuperior.workshopmongo.domain.Post;
import com.maicon.devsuperior.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "posts")
public class PostResource {

    @Autowired
    private PostService service;


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }
}
