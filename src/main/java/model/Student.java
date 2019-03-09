package main.java.model;

import java.util.ArrayList;

public class Student {
    private String name;
    private String id;
    private ArrayList<Scores> scores;
    public Student(String name,String id,ArrayList<Scores> scores) {
        this.name=name;
        this.id=id;
        this.scores=scores;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Scores> getScores() {
        return scores;
    }

    public void setScores(ArrayList<Scores> scores) {
        this.scores = scores;
    }
}
