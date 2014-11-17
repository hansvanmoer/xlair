/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.xlair.music.service.hibernate;

import org.hibernate.Criteria;

/**
 *
 * @author hans
 */
public interface CriteriaPreparator {
    
    Criteria prepare(Criteria criteria);
    
}
