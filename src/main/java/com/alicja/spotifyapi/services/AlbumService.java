package com.alicja.spotifyapi.services;

import com.alicja.spotifyapi.crudrepositories.AlbumRepository;
import com.alicja.spotifyapi.models.Album;
import com.alicja.spotifyapi.models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository){
        this.albumRepository= albumRepository;
    }

    public List<Album>  getAll(){
        List<Album> list = new ArrayList<>();
        albumRepository.findAll().iterator().forEachRemaining(list::add);//list.add while going through the elements
        return list;
    }

    public Album getByName(String name){
        return albumRepository.findByName(name);
    }
    public Album getById(String id){
        Optional<Album> albumOptional=albumRepository.findById(id);
        if(albumOptional.isPresent()){
            return albumOptional.get();
        }
        else {
            return null;
        }
    }


    public Album getAlbumBySongTitle (String title){
        Album album=null;
        List<Album> albumList =getAll();
        for (Album a:albumList) {
            for (Song s:a.getSongs()) {
                if(s.getName().equals(title)){
                    album=a;
                }
            }
        }
        return album;
    }

    public Album getByYear(int year){
        return albumRepository.findByYearOfRelease(year);
    }

    public Album addAlbum(Album album){
        return albumRepository.save(album);
    }

    public Album updateAlbum (String id, Album album){
        album.setId(id);
       return albumRepository.save(album);
    }
    public boolean delete (String id){
        albumRepository.deleteById(id);
        return true;
    }
}
