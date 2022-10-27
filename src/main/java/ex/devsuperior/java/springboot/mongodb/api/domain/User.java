package ex.devsuperior.java.springboot.mongodb.api.domain;

import ex.devsuperior.java.springboot.mongodb.api.dto.UserDTO;
import lombok.*;
import lombok.experimental.Tolerate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Document
public class User {
    @Id
    @NonNull
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @Setter(AccessLevel.NONE)
    @DBRef
    private List<Post> posts = new ArrayList<>();

    @Tolerate
    public User(UserDTO userDTO){
        id = userDTO.getId();
        name = userDTO.getName();
        email = userDTO.getEmail();
    }

    public void addPost(Post post){
        posts.add(post);
    }
}