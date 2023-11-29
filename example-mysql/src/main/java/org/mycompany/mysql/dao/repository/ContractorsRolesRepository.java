package org.mycompany.mysql.dao.repository;


import org.mycompany.mysql.models.Contractors;
import org.mycompany.mysql.models.ContractorsRoles;
import org.springframework.data.repository.CrudRepository;

public interface ContractorsRolesRepository extends CrudRepository<ContractorsRoles, Contractors.ContractorsPK> {
}
