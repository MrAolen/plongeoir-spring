package com.reeliant.plongeoir.dto;

import java.util.Date;
import com.reeliant.plongeoir.entity.Book.StateBook;

public class BookDTO{

    private Long id;
    private String title;
    private String summary;
    private Date parutionDate;
    private byte[] image;
    private StateBook state;
    private CategoryDTO category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getParutionDate() {
        return parutionDate;
    }

    public void setParutionDate(Date parutionDate) {
        this.parutionDate = parutionDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public StateBook getState() {
        return state;
    }

    public void setState(StateBook state) {
        this.state = state;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}
