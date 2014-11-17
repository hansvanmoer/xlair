/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.xlair.music.web.data;

import java.io.Serializable;

/**
 *
 * @author hans
 */
public interface OutputHandle<Model extends Serializable> {
        
    Serializable getValue(Model model);
        
}
