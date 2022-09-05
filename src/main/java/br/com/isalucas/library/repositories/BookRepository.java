package br.com.isalucas.library.repositories;

import br.com.isalucas.library.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<BookEntity, UUID> {
}