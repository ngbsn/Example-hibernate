package org.mycompany.dao.mysql.repository;

import org.mycompany.models.mysql.DeptEmp;
import org.springframework.data.repository.CrudRepository;

public interface DeptEmpRepository extends CrudRepository<DeptEmp, DeptEmp.DeptEmpPK> {
}
