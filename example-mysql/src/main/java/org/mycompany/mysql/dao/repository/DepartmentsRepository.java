package org.mycompany.mysql.dao.repository;

import org.mycompany.mysql.models.Departments;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentsRepository extends CrudRepository<Departments, String> {
}
