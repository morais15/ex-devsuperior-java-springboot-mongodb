package ex.devsuperior.java.springboot.mongodb.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private String id;
    private String text;
    private LocalDate date;
}
