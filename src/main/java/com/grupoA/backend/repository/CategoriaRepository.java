package com.grupoA.backend.repository;

import com.grupoA.backend.model.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    // No es necesario implementar metodos, Spring Data JPA lo hace automaticamente.
}