package ex.devsuperior.java.springboot.mongodb.api.controller;

import ex.devsuperior.java.springboot.mongodb.api.domain.Comment;
import ex.devsuperior.java.springboot.mongodb.api.domain.Post;
import ex.devsuperior.java.springboot.mongodb.api.domain.User;
import ex.devsuperior.java.springboot.mongodb.api.dto.CommentDTO;
import ex.devsuperior.java.springboot.mongodb.api.dto.PostDTO;
import ex.devsuperior.java.springboot.mongodb.api.service.PostService;
import ex.devsuperior.java.springboot.mongodb.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/posts")
public class PostController {
    private final PostService postService;
    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostDTO> findAll() {
        return postService.findAll()
                .stream()
                .map(PostDTO::new)
                .toList();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDTO findPostById(@PathVariable String id) {
        return new PostDTO(postService.findPostById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDTO createPost(@RequestBody PostDTO postDTO) {
        User user = userService.findByID(postDTO.getAuthor());
        Post post = postService.createPost(new Post(postDTO));
        user.addPost(post);
        userService.updateUser(user);
        return new PostDTO(post);
    }

    @PostMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public PostDTO createCommentInPost(@PathVariable String id, @RequestBody CommentDTO commentDTO) {
        Post post = postService.createCommentInPost(id, new Comment(commentDTO));
        postService.updatePost(post);
        return new PostDTO(post);
    }
}
