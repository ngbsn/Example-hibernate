package org.mycompany.dao.repository;

import org.mycompany.models.ContractorsRoles;
import org.mycompany.models.ContractorsSalaries;
import org.springframework.data.repository.CrudRepository;

public interface ContractorsRolesRepository extends CrudRepository<ContractorsRoles, ContractorsRoles.ContractorsRolesPK> {
}
