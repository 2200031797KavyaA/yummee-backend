package com.yummee.service;

import java.util.List;

import com.yummee.entity.Playlist;

public interface PlaylistService {
	
	Playlist createPlaylist(Playlist playlist);
    Playlist getPlaylistById(Long id);
    List<Playlist> getAllPlaylists();
    List<Playlist> getPlaylistsByUserId(Long userId);
    Playlist updatePlaylist(Long id, Playlist updatedPlaylist);
    void deletePlaylist(Long id);
}