package ex.devsuperior.java.springboot.mongodb.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import ex.devsuperior.java.springboot.mongodb.api.domain.Comment;
import ex.devsuperior.java.springboot.mongodb.api.domain.Post;
import ex.devsuperior.java.springboot.mongodb.api.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Tolerate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PostDTO {
    private String id;
    @JsonFormat(pattern="dd/MM/yyyy")
    @NonNull
    private LocalDate date;
    @NonNull
    private String title;
    @NonNull
    private String body;
    @NonNull
    private String author;

    private List<Comment> comments;

    @Tolerate
    public PostDTO(Post post){
        id = post.getId();
        date = post.getDate();
        title = post.getTitle();
        body = post.getBody();
        author = post.getAuthor();
        comments = post.getComments();
    }
}
