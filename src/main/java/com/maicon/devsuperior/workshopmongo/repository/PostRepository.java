package com.maicon.devsuperior.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.maicon.devsuperior.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
   
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String title);
    
    List<Post> findByTitleContainingIgnoreCase(String tet);
}
