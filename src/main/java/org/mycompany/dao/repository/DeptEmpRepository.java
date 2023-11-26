package org.mycompany.dao.repository;

import org.mycompany.models.DeptEmp;
import org.springframework.data.repository.CrudRepository;

public interface DeptEmpRepository extends CrudRepository<DeptEmp, DeptEmp.DeptEmpPK> {
}
