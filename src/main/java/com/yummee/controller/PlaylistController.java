package com.yummee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yummee.entity.Playlist;
import com.yummee.service.PlaylistService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {
	
	@Autowired
    private PlaylistService playlistService;

    @PostMapping
    public Playlist createPlaylist(@RequestBody Playlist playlist) {
        return playlistService.createPlaylist(playlist);
    }

    @GetMapping("/{id}")
    public Playlist getPlaylistById(@PathVariable Long id) {
        return playlistService.getPlaylistById(id);
    }

    @GetMapping
    public List<Playlist> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }

    @GetMapping("/user/{userId}")
    public List<Playlist> getPlaylistsByUserId(@PathVariable Long userId) {
        return playlistService.getPlaylistsByUserId(userId);
    }

    @PutMapping("/{id}")
    public Playlist updatePlaylist(@PathVariable Long id, @RequestBody Playlist updatedPlaylist) {
        return playlistService.updatePlaylist(id, updatedPlaylist);
    }

    @DeleteMapping("/{id}")
    public void deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
    }
}