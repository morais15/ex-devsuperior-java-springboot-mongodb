package ex.devsuperior.java.springboot.mongodb.api.service;

import ex.devsuperior.java.springboot.mongodb.api.domain.Post;
import ex.devsuperior.java.springboot.mongodb.api.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findPostById(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found."));
    }

    public Post createPost(Post post){
        return postRepository.save(post);
    }
}