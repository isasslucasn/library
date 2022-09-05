package br.com.isalucas.library.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "author")
@NoArgsConstructor
@Data
public class AuthorEntity {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id = UUID.randomUUID();

    @Column(name = "full_name", nullable = false, length = 80)
    private String fullName;

    @ManyToMany(mappedBy = "authors")
    private List<BookEntity> books = new ArrayList<>();

    public AuthorEntity(String fullName, List<BookEntity> books) {
        this.fullName = fullName;
        this.books = books;
    }
}