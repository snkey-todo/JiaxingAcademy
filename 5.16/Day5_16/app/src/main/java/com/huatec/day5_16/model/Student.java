package com.huatec.day5_16.model;

import java.util.List;

/**
 * Created by think on 2018/5/16.
 */

public class Student {
    private String name;
    private List<Course> courses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
