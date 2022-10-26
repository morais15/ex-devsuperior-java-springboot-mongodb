package ex.devsuperior.java.springboot.mongodb.api.dto;

import ex.devsuperior.java.springboot.mongodb.api.domain.Post;
import ex.devsuperior.java.springboot.mongodb.api.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Tolerate;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {
    @NonNull
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private List<Post> posts;

    @Tolerate
    public UserDTO(User user){
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        posts = user.getPosts();
    }
}