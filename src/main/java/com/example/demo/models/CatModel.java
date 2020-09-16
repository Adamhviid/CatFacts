package com.example.demo.models;

import java.util.Date;

public class CatModel implements Comparable<CatModel>{

    private String text;
    private Date createdAt;

    public CatModel(){
    }

    @Override
    public int compareTo(CatModel cm) {

        if (this.createdAt.before(cm.createdAt)) {
            return 1;

        } else if (this.createdAt.after(cm.createdAt)) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "\"" + text + " \" " + "<br>" +
                ", Created at [ " + createdAt + " ]" + "<br>" + "<br>";
    }

        public String getText() {
        return text;
    }
}


