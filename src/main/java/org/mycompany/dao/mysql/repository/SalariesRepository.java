package org.mycompany.dao.mysql.repository;

import org.mycompany.models.mysql.Salaries;
import org.springframework.data.repository.CrudRepository;

public interface SalariesRepository extends CrudRepository<Salaries, Salaries.SalariesPK> {
}
