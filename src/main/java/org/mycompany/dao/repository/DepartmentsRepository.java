package org.mycompany.dao.repository;

import org.mycompany.models.Departments;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentsRepository extends CrudRepository<Departments, String> {
}
