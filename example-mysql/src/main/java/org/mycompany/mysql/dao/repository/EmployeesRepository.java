package org.mycompany.mysql.dao.repository;

import org.mycompany.mysql.models.Employees;
import org.springframework.data.repository.CrudRepository;

public interface EmployeesRepository extends CrudRepository<Employees, Integer> {
}
