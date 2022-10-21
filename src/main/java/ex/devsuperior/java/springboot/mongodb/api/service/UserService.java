package ex.devsuperior.java.springboot.mongodb.api.service;

import ex.devsuperior.java.springboot.mongodb.api.domain.User;
import ex.devsuperior.java.springboot.mongodb.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
}