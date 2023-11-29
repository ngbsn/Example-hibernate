package org.mycompany.mysql.dao.repository;

import org.mycompany.mysql.models.Titles;
import org.springframework.data.repository.CrudRepository;

public interface TitlesRepository extends CrudRepository<Titles, Titles.TitlesPK> {
}
