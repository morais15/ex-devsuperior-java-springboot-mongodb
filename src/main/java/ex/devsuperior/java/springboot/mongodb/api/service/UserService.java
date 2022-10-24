package ex.devsuperior.java.springboot.mongodb.api.service;

import ex.devsuperior.java.springboot.mongodb.api.domain.User;
import ex.devsuperior.java.springboot.mongodb.api.dto.UserDTO;
import ex.devsuperior.java.springboot.mongodb.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(UserDTO::new).toList();
    }

    public UserDTO findByID(String id) {
        return new UserDTO(userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.")));
    }

    public UserDTO createUser(UserDTO userDTO){
        return new UserDTO(userRepository.save(new User(userDTO)));
    }
}