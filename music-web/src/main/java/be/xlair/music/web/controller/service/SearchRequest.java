/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.xlair.music.web.controller.service;

import java.io.Serializable;

/**
 *
 * @author hans
 */
public class SearchRequest implements Serializable{
    
    private Integer firstIndex;
    private Integer fetchSize;

    public SearchRequest() {
        this.firstIndex = 0;
        this.fetchSize = 0;
    }

    public SearchRequest(Integer firstIndex, Integer fetchSize) {
        this.firstIndex = firstIndex;
        this.fetchSize = fetchSize;
    }
    
    public Integer getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public Integer getFetchSize() {
        return fetchSize;
    }

    public void setFetchSize(int fetchSize) {
        this.fetchSize = fetchSize;
    }
    
}
