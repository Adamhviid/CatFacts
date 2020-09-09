package com.example.demo.models;

import java.util.Date;

public class CatModel implements Comparable<CatModel>{

    private String text;
    private Date createdAt;
    private Date updatedAt;

    public CatModel(){
    }

    @Override
    public int compareTo(CatModel cm) {

        if (cm.createdAt.after(createdAt)) {
            return -1;

        } if (cm.createdAt.before(createdAt)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Your Cat fact: \" " + text + " \" " + "<br>" +
                ", Created at [ " + createdAt + " ]" + "<br>" + "<br>";
    }

        public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}


