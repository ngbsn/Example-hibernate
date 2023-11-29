package org.mycompany.postgres1.dao.repository;

import org.mycompany.postgres1.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
