package com.maicon.devsuperior.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maicon.devsuperior.workshopmongo.domain.Post;
import com.maicon.devsuperior.workshopmongo.domain.User;
import com.maicon.devsuperior.workshopmongo.dto.UserDto;
import com.maicon.devsuperior.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> findAll() {
        List<User> list = service.findAll();        
        List<UserDto> listDto = list.stream().map((x) -> new UserDto(x)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(listDto);
    }

    @RequestMapping(value = "{id}" ,method = RequestMethod.GET)
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        User user = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new UserDto(user));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> insert(@RequestBody UserDto objDto) {
        User user = service.fromDto(objDto);
        user = service.insert(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping(value =  "{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserDto> update(@PathVariable String id, @RequestBody UserDto objDto) {
        User user = service.fromDto(objDto);
        user.setId(id);
        user = service.update(user);
        return ResponseEntity.status(HttpStatus.OK).body(new UserDto(user));
    }

    @RequestMapping(value = "{id}/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        User user = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user.getPosts());
    }
}
