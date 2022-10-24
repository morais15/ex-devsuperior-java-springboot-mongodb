package ex.devsuperior.java.springboot.mongodb.api.domain;

import ex.devsuperior.java.springboot.mongodb.api.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class User {
    @Id
    private String id;
    private String name;
    private String email;

    public User(UserDTO userDTO){
        id = userDTO.getId();
        name = userDTO.getName();
        email = userDTO.getEmail();
    }
}
