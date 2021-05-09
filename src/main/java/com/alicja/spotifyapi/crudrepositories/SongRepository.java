package com.alicja.spotifyapi.crudrepositories;

import com.alicja.spotifyapi.models.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Integer> {

    Song findByName(String name);

}
