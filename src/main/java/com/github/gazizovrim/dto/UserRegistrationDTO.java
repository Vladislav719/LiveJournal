package com.github.gazizovrim.dto;

/**
 * Created by vladislav on 10.05.2015.
 */
public class UserRegistrationDTO {
    private String password;
    private String confirmPassword;
    private String userName;



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
