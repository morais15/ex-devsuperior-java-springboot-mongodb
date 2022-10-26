package ex.devsuperior.java.springboot.mongodb.api.dto;

import ex.devsuperior.java.springboot.mongodb.api.domain.Post;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Tolerate;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PostDTO {
    @NonNull
    private LocalDate date;
    @NonNull
    private String title;
    @NonNull
    private String body;

    @Tolerate
    public PostDTO(Post post){
        date = post.getDate();
        title = post.getTitle();
        body = post.getBody();
    }
}
