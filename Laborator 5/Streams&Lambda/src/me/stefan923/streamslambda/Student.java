package me.stefan923.streamslambda;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private double average;
    private List<String> courses;

    public Student(String name, double average) {
        this.name = name;
        this.average = average;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void addCourse(String name) {
        courses.add(name);
    }
}
