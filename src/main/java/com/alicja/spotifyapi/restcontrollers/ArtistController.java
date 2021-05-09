package com.alicja.spotifyapi.restcontrollers;

import com.alicja.spotifyapi.models.Artist;
import com.alicja.spotifyapi.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArtistController {

    private ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artists")
    public List<Artist> getAll() {
        return artistService.getAllArtists();
    }

    @GetMapping("/artists/{id}")
    public Artist getById(@PathVariable int id) {
        return artistService.getArtistById(id);
    }

    @GetMapping("/artists/search")
    public Artist getById(@RequestParam String name) {
        return artistService.getArtistByName(name);
    }

    @PostMapping("/artists")
    public Artist addArtist(@RequestBody Artist artist) {
        return artistService.addArtist(artist);
    }

    @DeleteMapping("/artists/{id}")
    public boolean deleteArtist(@PathVariable int id) {
        return artistService.deleteArtist(id);
    }

    @PutMapping("/artists/{id}")
    public Artist updateArist(@PathVariable int id, @RequestBody Artist artist) {
        return artistService.updateArtist(id, artist);
    }
}
