package ex.devsuperior.java.springboot.mongodb.api.dto;

import ex.devsuperior.java.springboot.mongodb.api.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private String email;

    public UserDTO(User user){
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }
}