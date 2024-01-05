package br.com.carlosjunior.springmongodb.models.embedded;


import br.com.carlosjunior.springmongodb.models.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {
    private String id;
    private String name;

    public Author(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
