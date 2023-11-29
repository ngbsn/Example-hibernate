package org.mycompany.postgres1.dao.repository;

import org.mycompany.postgres1.models.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Integer> {
}
