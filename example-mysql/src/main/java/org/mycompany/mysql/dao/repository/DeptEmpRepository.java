package org.mycompany.mysql.dao.repository;

import org.mycompany.mysql.models.DeptEmp;
import org.springframework.data.repository.CrudRepository;

public interface DeptEmpRepository extends CrudRepository<DeptEmp, DeptEmp.DeptEmpPK> {
}
