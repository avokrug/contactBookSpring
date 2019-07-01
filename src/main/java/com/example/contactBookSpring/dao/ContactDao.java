package com.example.contactBookSpring.dao;

import com.example.contactBookSpring.domain.Type;

public class ContactDao {
    private Integer id;
    private Integer personId;
    private Type type;
    private String link;

    public ContactDao() {
    }

    public ContactDao(Integer id, Integer personId, Type type, String link) {
        this.id = id;
        this.personId = personId;
        this.type = type;
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(String Type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
}
