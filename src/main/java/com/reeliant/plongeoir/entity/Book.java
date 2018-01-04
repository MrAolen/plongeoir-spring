package com.reeliant.plongeoir.entity;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity(name = "book")
@Table(name = "BOOK")
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="summary")
    private String summary;
    @Column(name="parution")
    private Date parutionDate;
    @Column( name = "image" )
    private byte[] image;
    @ManyToOne
    @JoinColumn(name="CATEGORY_ID")
    private Category category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public enum StateBook {
        FREE,
        RESERVED,
    }
}
