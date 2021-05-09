package com.alicja.spotifyapi.services;

import com.alicja.spotifyapi.crudrepositories.ArtistRepository;
import com.alicja.spotifyapi.models.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }

    public List<Artist> getAllArtists(){
       return artistRepository.findAll();
    }

    public Artist getArtistById(int id){
       Optional<Artist> value =  artistRepository.findById(id);
       if(value.isEmpty()){
           return  null;
       }
       return value.get();
    }

    public Artist getArtistByName(String name){
      return   artistRepository.findByName(name);
    }

    public Artist addArtist(Artist artist){
       return artistRepository.save(artist);
    }

    public Artist updateArtist(int id, Artist artist){
        Artist a = getArtistById(id);
        if(a != null){
            a.setName(artist.getName());
            return artistRepository.save(a);
        }
        throw new IllegalArgumentException();

    }

    public boolean deleteArtist(int id){
        artistRepository.deleteById(id);
        return true;
    }

}
