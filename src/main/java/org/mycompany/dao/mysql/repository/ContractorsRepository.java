package org.mycompany.dao.mysql.repository;

import org.mycompany.models.mysql.Contractors;
import org.springframework.data.repository.CrudRepository;

public interface ContractorsRepository extends CrudRepository<Contractors, Contractors.ContractorsPK> {
}
