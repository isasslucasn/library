package br.com.isalucas.library.entities;

import br.com.isalucas.library.enums.CoverTypeEnum;
import br.com.isalucas.library.enums.LeafTypeEnum;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "book")
@Data
public class BookEntity {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id = UUID.randomUUID();

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "number_pages", nullable = false)
    private Integer numberPages;

    @Column(name = "leaf_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private LeafTypeEnum leafType;

    @Column(name = "cover_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private CoverTypeEnum coverType;

    @JoinColumn(name = "genre_id")
    @ManyToOne
    private GenreEntity genre;

    @ManyToMany
    @JoinTable(
        name = "book_author",
        joinColumns = @JoinColumn(
            name = "book_id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "author_id"
        )
    )
    private List<AuthorEntity> authors = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "book_publishing_company",
        joinColumns = @JoinColumn(
            name = "book_id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "publishing_company_id"
        )
    )
    private List<PublishingCompanyEntity> publishers = new ArrayList<>();
}