package br.com.carlosjunior.springmongodb.models.entities;

import br.com.carlosjunior.springmongodb.models.embedded.Author;
import br.com.carlosjunior.springmongodb.models.embedded.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "posts")
public class Post {

    @Id
    private String id;
    private Instant moment;
    private String title;
    private String body;
    private Author author;
    private List<Comment> comments = new ArrayList<>();

    public Post(String id, Instant moment, String title, String body, Author author) {
        this.id = id;
        this.moment = moment;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
