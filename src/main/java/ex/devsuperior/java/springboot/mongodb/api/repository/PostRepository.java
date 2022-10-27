package ex.devsuperior.java.springboot.mongodb.api.repository;

import ex.devsuperior.java.springboot.mongodb.api.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
