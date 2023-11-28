package org.mycompany.dao.postgres1.repository;

import org.mycompany.models.postgres1.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Integer> {
}
