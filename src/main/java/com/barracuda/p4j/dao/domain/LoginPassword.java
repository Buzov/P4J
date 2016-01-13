package com.barracuda.p4j.dao.domain;

import com.barracuda.p4j.dao.Identified;

/**
 *
 * @author artur
 */
public class LoginPassword implements Identified<Integer> {
    
    private Integer id;
    private String login;
    private String password;
    private Integer commentId;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Integer getId() {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}
