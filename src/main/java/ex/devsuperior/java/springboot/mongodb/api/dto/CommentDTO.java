package ex.devsuperior.java.springboot.mongodb.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import ex.devsuperior.java.springboot.mongodb.api.domain.Comment;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Tolerate;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CommentDTO {
    @NonNull
    private String text;
    @JsonFormat(pattern="dd/MM/yyyy")
    @NonNull
    private LocalDate date;
    @NonNull
    private String author;

    @Tolerate
    public CommentDTO(Comment comment){
        text = comment.getText();
        date = comment.getDate();
        author = comment.getAuthor();
    }
}