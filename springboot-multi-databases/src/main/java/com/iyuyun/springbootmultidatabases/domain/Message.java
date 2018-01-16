package com.iyuyun.springbootmultidatabases.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_message")
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String content;



    public Message(String name, String content) {

        this.name = name;
        this.content = content;
    }

    public Message() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
