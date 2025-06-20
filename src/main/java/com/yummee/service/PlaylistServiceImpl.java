package com.yummee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummee.entity.Playlist;
import com.yummee.entity.User;
import com.yummee.repository.PlaylistRepository;
import com.yummee.repository.UserRepository;

@Service
public class PlaylistServiceImpl implements PlaylistService{

	@Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Playlist createPlaylist(Playlist playlist) {
        if (playlist.getUser() != null) {
            Long userId = playlist.getUser().getId();
            User user = userRepository.findById(userId).orElse(null);
            if (user != null) {
                playlist.setUser(user);
                return playlistRepository.save(playlist);
            }
        }
        return null;
    }

    @Override
    public Playlist getPlaylistById(Long id) {
        return playlistRepository.findById(id).orElse(null);
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    @Override
    public List<Playlist> getPlaylistsByUserId(Long userId) {
        return playlistRepository.findByUserId(userId);
    }

    @Override
    public Playlist updatePlaylist(Long id, Playlist updatedPlaylist) {
        Optional<Playlist> existing = playlistRepository.findById(id);
        if (existing.isPresent()) {
            Playlist playlist = existing.get();
            playlist.setTitle(updatedPlaylist.getTitle());
            playlist.setRecipes(updatedPlaylist.getRecipes());
            return playlistRepository.save(playlist);
        }
        return null;
    }

    @Override
    public void deletePlaylist(Long id) {
        playlistRepository.deleteById(id);
    }
}