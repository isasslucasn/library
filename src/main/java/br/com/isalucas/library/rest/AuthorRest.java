package br.com.isalucas.library.rest;

import br.com.isalucas.library.entities.AuthorEntity;
import br.com.isalucas.library.repositories.AuthorRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("author")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorRest {


    AuthorRepository authorRepository;

    @PostMapping
    public AuthorEntity create(@RequestBody AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }

    @GetMapping
    public List<AuthorEntity> getAll() {
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorEntity> getId(@PathVariable UUID id) {
        try {
            AuthorEntity authorEntity = authorRepository
                .findById(id)
                .orElseThrow(
                    () -> new RuntimeException("Author not found")
                );
            return new ResponseEntity<>(
                authorEntity,
                HttpStatus.OK
            );
        } catch (RuntimeException runtimeException) {
            return new ResponseEntity<>(
                new AuthorEntity(),
                HttpStatus.NOT_FOUND
            );
        }
    }
}