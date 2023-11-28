package org.mycompany.dao.mysql.repository;

import org.mycompany.models.mysql.ContractorsSalaries;
import org.springframework.data.repository.CrudRepository;

public interface ContractorsSalariesRepository extends CrudRepository<ContractorsSalaries, ContractorsSalaries.ContractorsSalariesPK> {
}
