package br.com.carlosjunior.springmongodb.models.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {

    private String text;
    private Instant moment;
    private Author author;
}
