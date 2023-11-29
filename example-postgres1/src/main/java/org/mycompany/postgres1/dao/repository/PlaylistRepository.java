package org.mycompany.postgres1.dao.repository;

import org.mycompany.postgres1.models.Playlist;
import org.springframework.data.repository.CrudRepository;

public interface PlaylistRepository extends CrudRepository<Playlist, Integer> {
}
