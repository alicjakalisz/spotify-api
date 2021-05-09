package com.alicja.spotifyapi.crudrepositories;

import com.alicja.spotifyapi.models.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {

    List<Artist> findAll();

    Artist findByName(String name);


    //   public List<Artist> getAllArtists(){
    //       return artistRepository.getAll();
    //    }
    //
    //    public Artist getArtistById(int id){
    //       return artistRepository.getById(id);
    //    }
    //
    //    public Artist getArtistByName(String name){
    //      return   artistRepository.getByName(name);
    //    }
    //
    //    public Artist addArtist(Artist artist){
    //       return artistRepository.save(artist);
    //    }
    //
    //    public Artist updateArtist(int id, Artist artist){
    //        artist.setId(id);
    //        return artistRepository.save(artist);
    //    }
}
