package br.com.isalucas.library.repositories;

import br.com.isalucas.library.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorEntity, UUID> {
}