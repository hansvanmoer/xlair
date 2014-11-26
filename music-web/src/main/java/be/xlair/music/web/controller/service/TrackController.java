/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.xlair.music.web.controller.service;

import be.xlair.music.service.MusicServiceException;
import be.xlair.music.service.TrackService;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author hans
 */
@Controller
public class TrackController extends ServiceController{

    private static final Pattern SANITIZE_PATTERN = Pattern.compile("\\s+");
    
    @Autowired
    private TrackService trackService;

    @RequestMapping(value = "track", method = RequestMethod.GET)
    public void getTracks(@ModelAttribute SearchRequest searchRequest, HttpServletResponse response) throws MusicServiceException, IOException {
        if(searchRequest.getFilter() == null){
            writeResponse(response, (Serializable) trackService.getTracks(searchRequest.getFirstIndex(), searchRequest.getFetchSize()));
        }else{
            writeResponse(response, (Serializable) trackService.getTracks(getTerms(searchRequest.getFilter()), searchRequest.getFirstIndex(), searchRequest.getFetchSize()));
        }
    }

    private List<String> getTerms(String term){
        return Arrays.asList(SANITIZE_PATTERN.matcher(term.trim()).replaceAll(" "));
    }
    
    
    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }

}
