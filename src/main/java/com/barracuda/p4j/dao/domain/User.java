package com.barracuda.p4j.dao.domain;

import com.barracuda.p4j.dao.Identified;

/**
 *
 * @author artur
 */
public class User implements Identified<Integer> {
    
    private Integer id;
    private String login;
    private String password;
    private Integer questionId;
    private String answer;

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

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


}
