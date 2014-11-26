/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.xlair.music.web.view;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hans
 */
@Controller
public class ViewController {
    
    @RequestMapping()
    public ModelAndView renderWelcomePage(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("welcome");
        return mav;
    }
    
}
