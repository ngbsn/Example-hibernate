package org.mycompany.mysql.dao.repository;

import org.mycompany.mysql.models.Salaries;
import org.springframework.data.repository.CrudRepository;

public interface SalariesRepository extends CrudRepository<Salaries, Salaries.SalariesPK> {
}
