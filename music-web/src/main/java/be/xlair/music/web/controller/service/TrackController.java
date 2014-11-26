/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.xlair.music.web.controller.service;

import be.xlair.music.service.MusicServiceException;
import be.xlair.music.service.TrackService;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author hans
 */
@Controller
public class TrackController extends ServiceController{

    @Autowired
    private TrackService trackService;

    @RequestMapping(value = "track/list", method = RequestMethod.GET)
    public void getTracks(@ModelAttribute SearchRequest searchRequest, HttpServletResponse response) throws MusicServiceException, IOException {
        writeResponse(response, (Serializable) trackService.getTracks(searchRequest.getFirstIndex(), searchRequest.getFetchSize()));
    }


    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }

}
