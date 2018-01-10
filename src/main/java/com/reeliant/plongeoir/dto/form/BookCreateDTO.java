package com.reeliant.plongeoir.dto.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class BookCreateDTO{
    @NotNull(message = "")
    @Pattern(regexp = "\"[a-zA-Z]+\"",message = "")
    private String title;
    @NotNull
    private String parutionDate;
    @NotNull
    @Pattern(regexp = "\"[a-zA-Z]+\"")
    private String summary;
    @NotNull
    private MultipartFile image;
    @NotNull
    @Size(min = 1)
    private Long categoryId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParutionDate() {
        return parutionDate;
    }

    public void setParutionDate(String parutionDate) {
        this.parutionDate = parutionDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
