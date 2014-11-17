/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.xlair.music.service;

import java.util.List;
import be.xlair.music.model.User;
import be.xlair.music.model.Vote;

/**
 * @author hans
 */
public interface UserService extends FacetedSearch<User>{
    
    void addUser(User user) throws MusicServiceException;
    
    void addUser(User user, List<Vote> votes) throws MusicServiceException;
    
    List<User> getUsers() throws MusicServiceException;
    
    User getUser(Long userId) throws MusicServiceException;
    
    void updateScores(Integer answer) throws MusicServiceException;
    
}
