package org.mycompany.dao.repository;

import org.mycompany.models.Contractors;
import org.mycompany.models.ContractorsRoles;
import org.springframework.data.repository.CrudRepository;

public interface ContractorsRolesRepository extends CrudRepository<ContractorsRoles, Contractors.ContractorsPK> {
}
