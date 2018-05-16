package com.huatec.day5_16.model;

/**
 * Created by think on 2018/5/16.
 */

public class Course {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Course(String name) {
        this.name = name;
    }
}
