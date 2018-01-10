package com.reeliant.plongeoir.dto.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserCreationDTO{
    @NotNull
    @Size(min=3, max=8)
    @Pattern(regexp = "([a-zA-Z0-9]{3}$)")
    private String username;
    @NotNull
    @Pattern(regexp = "((?=.*\\\\d)(?=.*[a-zA-Z])(?=.*[@#$%*]).{8,15})")
    private String password;
    @NotNull
    @Pattern(regexp = "((?=.*\\\\d)(?=.*[a-zA-Z])(?=.*[@#$%*]).{8,15})")
    private String confirmPassword;
    @NotNull
    @Pattern(regexp = "\"[a-zA-Z]+\"")
    private String name;
    @NotNull
    @Pattern(regexp = "\"[a-zA-Z]+\"")
    private String forname;
    @NotNull
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String email;
    @NotNull
    @Min(1)
    @Max(99)
    private int age;

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
