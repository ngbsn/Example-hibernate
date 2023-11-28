package org.mycompany.dao.mysql.repository;

import org.mycompany.models.mysql.Contractors;
import org.mycompany.models.mysql.ContractorsRoles;
import org.springframework.data.repository.CrudRepository;

public interface ContractorsRolesRepository extends CrudRepository<ContractorsRoles, Contractors.ContractorsPK> {
}
