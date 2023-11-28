package org.mycompany.dao.mysql.repository;

import org.mycompany.models.mysql.Titles;
import org.springframework.data.repository.CrudRepository;

public interface TitlesRepository extends CrudRepository<Titles, Titles.TitlesPK> {
}
