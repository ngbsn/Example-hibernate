package org.mycompany.dao.postgres1.repository;

import org.mycompany.models.postgres1.MediaType;
import org.springframework.data.repository.CrudRepository;

public interface MediaTypeRepository extends CrudRepository<MediaType, Integer> {
}
