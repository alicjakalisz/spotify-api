package com.alicja.spotifyapi.services;

import com.alicja.spotifyapi.crudrepositories.SongRepository;
import com.alicja.spotifyapi.models.Album;
import com.alicja.spotifyapi.models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {


    private SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository){
        this.songRepository=songRepository;
    }

    public Song getById (int id){

       if(songRepository.findById(id).isPresent()){
           return songRepository.findById(id).get();
       }
       else{
           return null;
       }
    }
    public List<Song> getAllSongs(){
        List<Song> list = new ArrayList<>();
        songRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public Song getSongByName(String name){
        return songRepository.findByName(name);
    }

    public boolean updateSong( int id, Song song){
        song.setId(id);
        songRepository.save(song);
        return true;
    }

    public Song addSong (  Song song){
        //Check if the album exist and as well the artist
        songRepository.save(song);
        return song;
    }

    public void deleteSong (int id){
        songRepository.deleteById(id);
    }

    public List<Song> getAllSongsByAlbumName(String albumName){
        //TODO
        return null;
    }
}
