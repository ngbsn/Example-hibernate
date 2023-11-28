package org.mycompany.dao.postgres1.repository;

import org.mycompany.models.postgres1.Playlist;
import org.springframework.data.repository.CrudRepository;

public interface PlaylistRepository extends CrudRepository<Playlist, Integer> {
}
