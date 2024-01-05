package br.com.carlosjunior.springmongodb.services;

import br.com.carlosjunior.springmongodb.models.dto.PostDTO;
import br.com.carlosjunior.springmongodb.models.dto.UserDTO;
import br.com.carlosjunior.springmongodb.models.entities.User;
import br.com.carlosjunior.springmongodb.repositories.UserRepository;
import br.com.carlosjunior.springmongodb.config.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll() {
        List<User> lista = repository.findAll();
        return lista.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public UserDTO findById(String id) {
        return new UserDTO(findByIdEntity(id));
    }

    private User findByIdEntity(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }

    public UserDTO createUser(UserDTO dto) {
        User entity = new User();
        copyDtoToEntity(dto, entity);
        return new UserDTO(repository.insert(entity));
    }

    private void copyDtoToEntity(UserDTO dto, User entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
    }

    public UserDTO updateUser(String id, UserDTO dto) {
        User entity = findByIdEntity(id);
        copyDtoToEntity(dto, entity);
        return new UserDTO(repository.save(entity));
    }

    public void deleteUser(String id) {
        findByIdEntity(id);
        repository.deleteById(id);
    }

    public List<PostDTO> findPostsUser(String id) {
        User entity = findByIdEntity(id);
        return entity.getPosts().stream().map(PostDTO::new).collect(Collectors.toList());
    }

}
