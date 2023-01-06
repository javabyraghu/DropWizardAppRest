package com.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author {
    @Id
    @Column(name="aid")
    @JsonProperty
    private Integer authId;
    @Column(name="aname")
    @JsonProperty
    private String name;

    public Author() {

    }

    public Integer getAuthId() {
        return authId;
    }

    public String getName() {
        return name;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authId=" + authId +
                ", name='" + name + '\'' +
                '}';
    }
}
