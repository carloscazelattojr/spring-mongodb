package br.com.carlosjunior.springmongodb.repositories;

import br.com.carlosjunior.springmongodb.models.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
