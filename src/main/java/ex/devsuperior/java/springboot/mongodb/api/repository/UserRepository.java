package ex.devsuperior.java.springboot.mongodb.api.repository;

import ex.devsuperior.java.springboot.mongodb.api.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
