package org.mycompany.dao.mysql.repository;

import org.mycompany.models.mysql.Employees;
import org.springframework.data.repository.CrudRepository;

public interface EmployeesRepository extends CrudRepository<Employees, Integer> {
}
