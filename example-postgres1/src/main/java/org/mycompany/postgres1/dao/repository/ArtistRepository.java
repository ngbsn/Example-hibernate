package org.mycompany.postgres1.dao.repository;

import org.mycompany.postgres1.models.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {
}
