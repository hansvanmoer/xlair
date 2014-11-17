/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.xlair.music.service.hibernate.facet;

import org.hibernate.Criteria;
import be.xlair.music.service.SortOrder;

/**
 *
 * @author hans
 */
public interface HibernateFacet {
    
    Criteria addOrder(Criteria criteria, SortOrder sortOrder);
    
}
