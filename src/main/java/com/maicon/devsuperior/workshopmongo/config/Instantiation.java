package com.maicon.devsuperior.workshopmongo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.maicon.devsuperior.workshopmongo.domain.Post;
import com.maicon.devsuperior.workshopmongo.domain.User;
import com.maicon.devsuperior.workshopmongo.dto.AuthorDto;
import com.maicon.devsuperior.workshopmongo.repository.PostRepository;
import com.maicon.devsuperior.workshopmongo.repository.UserRepository;

import java.util.Arrays;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

@Configuration
public class Instantiation implements CommandLineRunner {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, LocalDate.parse("21/03/2018", formatter), "Partiu Viagem!", "Vou viajar para São Paulo.", new AuthorDto(maria));
        Post post2 = new Post(null, LocalDate.parse("23/03/2018", formatter), "Bom Dia!", "Acordei feliz hoje", new AuthorDto(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));


        maria.getPosts().addAll((Arrays.asList(post1, post2)));
        userRepository.save(maria);
    }

}
