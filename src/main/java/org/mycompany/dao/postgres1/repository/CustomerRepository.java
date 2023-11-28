package org.mycompany.dao.postgres1.repository;

import org.mycompany.models.postgres1.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
