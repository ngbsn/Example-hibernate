package org.mycompany.dao.postgres1.repository;

import org.mycompany.models.postgres1.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {
}
