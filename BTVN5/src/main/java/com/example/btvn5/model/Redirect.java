package com.example.btvn5.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
public class Redirect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @NaturalId
    @Column(unique = true, nullable = false)
    private String subUrl;

    public Redirect() {
    }

    public Redirect(Long id, String url, String subUrl) {
        this.id = id;
        this.url = url;
        this.subUrl = subUrl;
    }

    public Redirect(String startUrl, String randomUrl) {
        this.url = startUrl;
        this.subUrl = randomUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSubUrl() {
        return subUrl;
    }

    public void setSubUrl(String subUrl) {
        this.subUrl = subUrl;
    }
}
