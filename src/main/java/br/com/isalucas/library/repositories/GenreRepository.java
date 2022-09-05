package br.com.isalucas.library.repositories;

import br.com.isalucas.library.entities.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GenreRepository extends JpaRepository<GenreEntity, UUID> {
}
