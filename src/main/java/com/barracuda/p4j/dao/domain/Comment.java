package com.barracuda.p4j.dao.domain;

import com.barracuda.p4j.dao.Identified;

/**
 *
 * @author artur
 */
public class Comment implements Identified<Integer>{
    
    private Integer id = null;
    private String comment;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
