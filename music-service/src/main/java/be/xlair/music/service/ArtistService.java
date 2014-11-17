/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.xlair.music.service;

import be.xlair.music.model.Artist;

/**
 *
 * @author hans
 */
public interface ArtistService {
    
    Artist addArtist(Artist artist) throws MusicServiceException;
    
    Artist getArtist(Long artistId) throws MusicServiceException;
    
    Artist getArtist(String name) throws MusicServiceException;
}
