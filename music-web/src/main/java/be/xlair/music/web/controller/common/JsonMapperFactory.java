/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.xlair.music.web.controller.common;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author hans
 */
@Configuration
public class JsonMapperFactory implements InitializingBean{
    
    private ObjectMapper objectMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        objectMapper = new ObjectMapper();
    }

    @Bean
    public ObjectMapper getObjectMapper(){
        return objectMapper;
    }
}
