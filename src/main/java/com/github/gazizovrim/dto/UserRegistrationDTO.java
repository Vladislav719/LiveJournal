package com.github.gazizovrim.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by vladislav on 10.05.2015.
 */
public class UserRegistrationDTO {

    @Size(min = 3)
    private String password;
    @NotNull
    private String confirmPassword;
    @NotNull
    @Size(min = 3)
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
