package org.mycompany.dao.repository;

import org.mycompany.models.Contractors;
import org.springframework.data.repository.CrudRepository;

public interface ContractorsRepository extends CrudRepository<Contractors, Contractors.ContractorsPK> {
}
