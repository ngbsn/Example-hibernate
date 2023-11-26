package org.mycompany.dao.repository;

import org.mycompany.models.Salaries;
import org.springframework.data.repository.CrudRepository;

public interface SalariesRepository extends CrudRepository<Salaries, Salaries.SalariesPK> {
}
