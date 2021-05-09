package com.alicja.spotifyapi.restcontrollers;

import com.alicja.spotifyapi.models.Album;
import com.alicja.spotifyapi.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class AlbumController {

    AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService){
        this.albumService = albumService;
    }

    @GetMapping(path = "/albums")
    public List<Album>getAllAlbums(){
        return albumService.getAll();
    }

    @GetMapping(path = "/albums/{id}")
    public Album getAlbumById (@PathVariable String id){
        return albumService.getById(id);
    }

    @GetMapping(path = "/albums/{name}")
    public Album getAlbumByName (@PathVariable String name){
        return albumService.getByName (name);
    }
    @GetMapping(path="/albums/{id}/song/{title}")
    public Album getAlbumBySongTitle(@PathVariable String songTitle){
        return albumService.getAlbumBySongTitle(songTitle);
    }

    @GetMapping(path = "/albums/{year}")
    public Album getAlbumByYear (@PathVariable int year){
        return albumService.getByYear (year);
    }

    @PostMapping(path = "/albums")
    public Album addAlbum(@RequestBody Album album){
        return albumService.addAlbum(album);
    }
    @PutMapping(path="/albums/{id}")
    public Album updateAlbum(@PathVariable String id, @RequestBody Album album){
        album.setId(id);
       return albumService.updateAlbum(id, album);
    }

    @DeleteMapping(path="/albums/{id}")
    public boolean deleteAlbum(@PathVariable String id){
        return albumService.delete(id);
    }

}
