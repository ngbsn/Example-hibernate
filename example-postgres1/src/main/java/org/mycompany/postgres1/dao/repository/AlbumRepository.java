package org.mycompany.postgres1.dao.repository;

import org.mycompany.postgres1.models.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Integer> {
}
