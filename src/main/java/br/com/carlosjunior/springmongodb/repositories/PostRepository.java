package br.com.carlosjunior.springmongodb.repositories;

import br.com.carlosjunior.springmongodb.models.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
