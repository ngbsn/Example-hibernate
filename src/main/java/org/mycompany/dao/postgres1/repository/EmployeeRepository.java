package org.mycompany.dao.postgres1.repository;

import org.mycompany.models.postgres1.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
