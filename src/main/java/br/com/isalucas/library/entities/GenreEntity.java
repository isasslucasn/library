package br.com.isalucas.library.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "genre")
@Data
public class GenreEntity {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id = UUID.randomUUID();

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @OneToMany(mappedBy = "genre")
    private List<BookEntity> books = new ArrayList<>();
}