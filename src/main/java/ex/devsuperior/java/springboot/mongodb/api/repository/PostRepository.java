package ex.devsuperior.java.springboot.mongodb.api.repository;

import ex.devsuperior.java.springboot.mongodb.api.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
