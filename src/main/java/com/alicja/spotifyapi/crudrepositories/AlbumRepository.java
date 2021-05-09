package com.alicja.spotifyapi.crudrepositories;

import com.alicja.spotifyapi.models.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album,String> {
    Album findByName(String name);

    Album findByYearOfRelease(int year);


}
