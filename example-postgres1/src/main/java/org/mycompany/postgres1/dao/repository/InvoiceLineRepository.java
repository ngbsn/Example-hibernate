package org.mycompany.postgres1.dao.repository;

import org.mycompany.postgres1.models.InvoiceLine;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceLineRepository extends CrudRepository<InvoiceLine, Integer> {
}
