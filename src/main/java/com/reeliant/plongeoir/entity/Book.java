package com.reeliant.plongeoir.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "book")
@Table(name = "BOOK")
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="titre")
    private String titre;
    @Column(name="summary")
    private String summary;
    @Column(name="parution")
    private Date parutionDate;
    @Column(name="image")
    private String image;
    @Column(name="state")
    @Enumerated(EnumType.STRING)
    private StateBook state;
    @ManyToOne
    @JoinColumn(name="CATEGORY_ID")
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public StateBook getState() {
        return state;
    }

    public void setState(StateBook state) {
        this.state = state;
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
