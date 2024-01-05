package br.com.carlosjunior.springmongodb.controllers;

import br.com.carlosjunior.springmongodb.models.dto.PostDTO;
import br.com.carlosjunior.springmongodb.models.dto.UserDTO;
import br.com.carlosjunior.springmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO dto) {
        UserDTO newUserDTO = service.createUser(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{}}").buildAndExpand(newUserDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(newUserDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable String id, @RequestBody UserDTO dto) {
        return new ResponseEntity<>(service.updateUser(id, dto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteUser(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<PostDTO>> findPostsUser(@PathVariable String id) {
        return new ResponseEntity<>(service.findPostsUser(id), HttpStatus.OK);
    }


}
