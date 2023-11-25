package org.mycompany.dao.repository;

import org.mycompany.models.Employees;
import org.springframework.data.repository.CrudRepository;

public interface EmployeesRepository extends CrudRepository<Employees, Integer> {
}
