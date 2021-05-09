package com.alicja.spotifyapi.restcontrollers;

import com.alicja.spotifyapi.models.Album;
import com.alicja.spotifyapi.models.Artist;
import com.alicja.spotifyapi.models.Song;
import com.alicja.spotifyapi.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SongController {

    SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/songs")
    public List<Song> getAll() {
        return songService.getAllSongs();
    }


    @GetMapping(path = "/songs/{id}")
    public Song getSongById(@PathVariable int id) {
        return songService.getById(id);
    }

    @GetMapping("/songs/search")
    public Song getByName(@RequestParam String name) {
        return songService.getSongByName(name);
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song) {
        return songService.addSong(song);
    }

    @DeleteMapping("/songs/{id}")
    public void deleteSong(@PathVariable int id) {
        songService.deleteSong(id);
    }

    @PutMapping("/songs/{id}")
    public boolean updateSong(@PathVariable int id, @RequestBody Song song) {
        return songService.updateSong(id, song);
    }

    @GetMapping(path = "/albums/{name}/songs")
    public List<Song> getAllSongsByAlbumName(String albumName) {
        return songService.getAllSongsByAlbumName(albumName);
    }
}
