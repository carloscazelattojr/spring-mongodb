package br.com.carlosjunior.springmongodb.models.dto;

import br.com.carlosjunior.springmongodb.models.embedded.Author;
import br.com.carlosjunior.springmongodb.models.embedded.Comment;
import br.com.carlosjunior.springmongodb.models.entities.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDTO {

    private String id;
    private Instant moment;
    private String title;
    private String body;
    private Author author;
    private List<Comment> comments = new ArrayList<>();

    public PostDTO(Post entity) {
        this.id = entity.getId();
        this.moment = entity.getMoment();
        this.title = entity.getTitle();
        this.body = entity.getBody();
        this.author = entity.getAuthor();
        this.comments.addAll(entity.getComments());
    }
}
