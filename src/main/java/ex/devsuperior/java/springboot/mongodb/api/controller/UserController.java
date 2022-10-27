package ex.devsuperior.java.springboot.mongodb.api.controller;

import ex.devsuperior.java.springboot.mongodb.api.domain.User;
import ex.devsuperior.java.springboot.mongodb.api.dto.PostDTO;
import ex.devsuperior.java.springboot.mongodb.api.dto.UserDTO;
import ex.devsuperior.java.springboot.mongodb.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findAll(){
        return userService.findAll()
                .stream()
                .map(UserDTO::new)
                .toList();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findById(@PathVariable String id){
        return new UserDTO(userService.findByID(id));
    }

    @GetMapping(value = "/{id}/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDTO> findPostsByUserId(@PathVariable String id){
        return userService.findByID(id).getPosts().stream().map(PostDTO::new).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return new UserDTO(userService.createUser(new User(userDTO)));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@PathVariable String id, @RequestBody UserDTO userDTO){
        userDTO.setId(id);
        return userService.updateUser(new User(userDTO));
    }
}