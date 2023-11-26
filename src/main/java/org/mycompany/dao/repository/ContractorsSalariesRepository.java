package org.mycompany.dao.repository;

import org.mycompany.models.ContractorsSalaries;
import org.mycompany.models.Titles;
import org.springframework.data.repository.CrudRepository;

public interface ContractorsSalariesRepository extends CrudRepository<ContractorsSalaries, ContractorsSalaries.ContractorsSalariesPK> {
}
