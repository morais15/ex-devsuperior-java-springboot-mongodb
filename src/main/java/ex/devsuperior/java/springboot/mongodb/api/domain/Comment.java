package ex.devsuperior.java.springboot.mongodb.api.domain;

import ex.devsuperior.java.springboot.mongodb.api.dto.CommentDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Tolerate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Comment {
    @NonNull
    private String text;
    @NonNull
    private LocalDate date;
    @NonNull
    private String author;

    @Tolerate
    public Comment(CommentDTO commentDTO){
        text = commentDTO.getText();
        date = commentDTO.getDate();
        author = commentDTO.getAuthor();
    }
}
