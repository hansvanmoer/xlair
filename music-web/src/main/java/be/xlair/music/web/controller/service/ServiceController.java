/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.xlair.music.web.controller.service;

import be.xlair.music.service.MusicServiceException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author hans
 */
public abstract class ServiceController {
 
    private static final Logger LOG = LoggerFactory.getLogger(ServiceController.class);
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Unable to write response")
    @ExceptionHandler({IOException.class, MusicServiceException.class})
    public void handleJsonMappingException(Exception e) {
        LOG.error("uncaught exception", e);
    }
    
    protected void writeResponse(HttpServletResponse response, Serializable data) throws IOException{
        response.setContentType("application/json");
        OutputStream output = response.getOutputStream();
        try{
            objectMapper.writeValue(output, data);
        }finally{
            try{
                output.close();
            }catch(IOException e){
                LOG.warn("unabelt to close response output stream",e);
            }
        }
    };
    
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

}
