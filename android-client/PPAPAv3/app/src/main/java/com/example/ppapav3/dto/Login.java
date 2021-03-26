package com.example.ppapav3.dto;

import com.example.ppapav3.model.ROLE;

public class Login {
    private String user;
    private String pass;
    private ROLE role;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    public ROLE getRole() {
        return role;
    }

    public void setPass(ROLE role) {
        this.pass = pass;
    }
}
