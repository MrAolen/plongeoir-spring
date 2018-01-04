package com.reeliant.plongeoir.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class BookCreateDTO{
    private String title;
    private Date parutionDate;
    private String summary;
    private MultipartFile image;
    private Long categoryId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getParutionDate() {
        return parutionDate;
    }

    public void setParutionDate(Date parutionDate) {
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
