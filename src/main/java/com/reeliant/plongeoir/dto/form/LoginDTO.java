package com.reeliant.plongeoir.dto.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginDTO{
    @NotNull
    @Size(min=3, max=8)
    @Pattern(regexp = "([a-zA-Z0-9]{3}$)")
    private String username;
    @NotNull
    @Pattern(regexp = "((?=.*\\\\d)(?=.*[a-zA-Z])(?=.*[@#$%*]).{8,15})")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
