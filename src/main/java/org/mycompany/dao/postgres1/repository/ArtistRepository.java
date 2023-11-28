package org.mycompany.dao.postgres1.repository;

import org.mycompany.models.postgres1.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {
}
