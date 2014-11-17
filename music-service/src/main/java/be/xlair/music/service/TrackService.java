/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.xlair.music.service;

import java.util.Collection;
import java.util.List;
import be.xlair.music.facet.Facet;
import be.xlair.music.model.QueryResult;
import be.xlair.music.model.Track;

/**
 *
 * @author hans
 */
public interface TrackService extends FacetedSearch<Track> {
    
    void addTrack(Track track) throws MusicServiceException;
    
    List<Track> getTracks() throws MusicServiceException;
    
    QueryResult<Track> getTracks(int firstResultIndex, int maxResultCount) throws MusicServiceException;
            
    List<Track> getTracksByScore() throws MusicServiceException;
    
    QueryResult<Track> getTracksByScore(int firstResultIndex, int maxResultCount) throws MusicServiceException;
    
    QueryResult<Track> getTracks(Collection<String> searchTerms, int firstResultIndex, int maxResultCount) throws MusicServiceException;
    
    List<Track> getTracks(Collection<String> searchTerms) throws MusicServiceException;
    
    Track getTrack(Long trackId) throws MusicServiceException;
    
    void updateScores() throws MusicServiceException;
    
    void updateRanks() throws MusicServiceException;
}
