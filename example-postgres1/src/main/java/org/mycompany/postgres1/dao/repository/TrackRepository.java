package org.mycompany.postgres1.dao.repository;

import org.mycompany.postgres1.models.Track;
import org.springframework.data.repository.CrudRepository;

public interface TrackRepository extends CrudRepository<Track, Integer> {
}
