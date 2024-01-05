package br.com.carlosjunior.springmongodb.services;

import br.com.carlosjunior.springmongodb.config.exceptions.ResourceNotFoundException;
import br.com.carlosjunior.springmongodb.models.dto.PostDTO;
import br.com.carlosjunior.springmongodb.models.entities.Post;
import br.com.carlosjunior.springmongodb.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public PostDTO findById(String id) {
        return new PostDTO(findByIdEntity(id));
    }

    private Post findByIdEntity(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post não encontrado"));
    }

}
