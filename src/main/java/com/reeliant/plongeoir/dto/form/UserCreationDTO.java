package com.reeliant.plongeoir.dto.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class UserCreationDTO{
    @NotNull
    @Size(min=3, max=8, message="La taille de l'identifiant doit être compris entre 3 et 8")
    @Pattern(regexp = "([a-zA-Z0-9]*)", message="L'identifiant doit être composé que de charactère alphanumérique")
    private String username;
    @NotNull
    @Size(min=8, max=15, message="Le mot de passe doit être en 8 et 15 charactère")
    @Pattern(regexp = "((?=.*\\\\d)(?=.*[a-zA-Z])(?=.*[@#$%*]))")
    private String password;
    @NotNull
    @Size(min=8, max=15, message="Le mot de passe doit être en 8 et 15 charactère")
    @Pattern(regexp = "((?=.*\\\\d)(?=.*[a-zA-Z])(?=.*[@#$%*]))")
    private String confirmPassword;
    @NotNull
    @Pattern(regexp = "[a-zA-Z]+", message="Prenom non valide")
    private String name;
    @NotNull
    @Pattern(regexp = "[a-zA-Z]+", message="Prenom non valide")
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
