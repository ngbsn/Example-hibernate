package org.mycompany.postgres1.dao.repository;

import org.mycompany.postgres1.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
