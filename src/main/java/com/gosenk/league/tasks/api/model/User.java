package com.gosenk.league.tasks.api.model;

public class User {

    public User(String name){
        this.id = 1L;
    }

    private Long id;
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
