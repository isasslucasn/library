package br.com.isalucas.library.repositories;

import br.com.isalucas.library.entities.PublishingCompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublishingCompanyRepository extends JpaRepository<PublishingCompanyEntity, UUID> {
}
