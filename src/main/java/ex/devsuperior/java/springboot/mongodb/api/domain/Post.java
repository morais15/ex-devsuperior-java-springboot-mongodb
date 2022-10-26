package ex.devsuperior.java.springboot.mongodb.api.domain;

import ex.devsuperior.java.springboot.mongodb.api.dto.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Tolerate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Post {
    @NonNull
    private LocalDate date;
    @NonNull
    private String title;
    @NonNull
    private String body;

    @Tolerate
    public Post(PostDTO postDTO){
        date = postDTO.getDate();
        title = postDTO.getTitle();
        body = postDTO.getBody();
    }
}
