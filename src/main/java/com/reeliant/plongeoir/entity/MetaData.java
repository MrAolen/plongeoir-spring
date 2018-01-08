package com.reeliant.plongeoir.entity;

import javax.persistence.*;

@Entity(name = "metadata")
@Table(name="METADATA_WEBSITE")
public class MetaData{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="key_data")
    private String key;
    @Column(name="value_data")
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
