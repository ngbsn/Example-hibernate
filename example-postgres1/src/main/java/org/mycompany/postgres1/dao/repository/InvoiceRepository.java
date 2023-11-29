package org.mycompany.postgres1.dao.repository;

import org.mycompany.postgres1.models.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {
}
