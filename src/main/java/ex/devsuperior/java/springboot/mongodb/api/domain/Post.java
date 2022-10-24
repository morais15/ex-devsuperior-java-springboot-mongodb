package ex.devsuperior.java.springboot.mongodb.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private String id;
    private LocalDate date;
    private String title;
    private String body;
}
