package org.mycompany.dao.mysql.repository;

import org.mycompany.models.mysql.Departments;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentsRepository extends CrudRepository<Departments, String> {
}
