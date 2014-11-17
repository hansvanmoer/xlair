/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.xlair.music.service.hibernate;

import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import be.xlair.music.model.Artist;
import be.xlair.music.service.ArtistService;
import be.xlair.music.service.MusicServiceException;

/**
 *
 * @author hans
 */
public class HibernateArtistService extends HibernateService<Artist, Long> implements ArtistService, Serializable{

    public HibernateArtistService() {
        super(Artist.class);
    }

    @Override
    public Artist addArtist(Artist artist) throws MusicServiceException {
        return super.saveOrUpdate(artist);
    }

    @Override
    public Artist getArtist(Long artistId) throws MusicServiceException {
        return super.get(artistId);
    }

    @Override
    public Artist getArtist(String name) throws MusicServiceException {
        return super.getUniqueResult(new GetByName(name));
    }
    
    private static class GetByName implements CriteriaPreparator {
        
        private String name;
        
        public GetByName(String name){
            this.name = name;
        }
        
        @Override
        public Criteria prepare(Criteria criteria) {
            return criteria.add(Restrictions.eq("name", name));
        }
    }
    
}
