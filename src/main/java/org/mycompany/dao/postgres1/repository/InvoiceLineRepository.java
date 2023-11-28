package org.mycompany.dao.postgres1.repository;

import org.mycompany.models.postgres1.InvoiceLine;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceLineRepository extends CrudRepository<InvoiceLine, Integer> {
}
