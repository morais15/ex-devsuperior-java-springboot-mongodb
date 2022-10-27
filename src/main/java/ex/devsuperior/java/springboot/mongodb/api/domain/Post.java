package ex.devsuperior.java.springboot.mongodb.api.domain;

import ex.devsuperior.java.springboot.mongodb.api.dto.PostDTO;
import lombok.*;
import lombok.experimental.Tolerate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Document
public class Post {
    @Id
    @NonNull
    private String id;
    @NonNull
    private LocalDate date;
    @NonNull
    private String title;
    @NonNull
    private String body;
    @NonNull
    private String author;
    @Setter(AccessLevel.NONE)
    private List<Comment> comments = new ArrayList<>();

    @Tolerate
    public Post(PostDTO postDTO){
        id = postDTO.getId();
        date = postDTO.getDate();
        title = postDTO.getTitle();
        body = postDTO.getBody();
        author = postDTO.getAuthor();
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }
}