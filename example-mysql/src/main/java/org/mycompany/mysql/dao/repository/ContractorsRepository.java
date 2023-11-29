package org.mycompany.mysql.dao.repository;

import org.mycompany.mysql.models.Contractors;
import org.springframework.data.repository.CrudRepository;

public interface ContractorsRepository extends CrudRepository<Contractors, Contractors.ContractorsPK> {
}
