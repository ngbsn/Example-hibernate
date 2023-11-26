package org.mycompany.dao.repository;

import org.mycompany.models.Titles;
import org.springframework.data.repository.CrudRepository;

public interface TitlesRepository extends CrudRepository<Titles, Titles.TitlesPK> {
}
