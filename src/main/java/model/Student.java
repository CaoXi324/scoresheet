package main.java.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private static long serialVersionUID = 1l;
    private String name;
    private String id;
    private ArrayList<Scores> scores;
    private Double averageScore;
    private Double totalScore;

    public Student(String name, String id, ArrayList<Scores> scores) {
        this.name = name;
        this.id = id;
        this.scores = scores;
    }

    public Student() {

    }

    public void setAverageScore() {
        this.averageScore = scores.stream().map(ele -> ele.getScore()).reduce(0.0, (a, b) -> a + b) / scores.size();
    }

    public void setTotalScore() {
        this.averageScore = scores.stream().map(ele -> ele.getScore()).reduce(0.0, (a, b) -> a + b);

    }

    public Double getAverageScore() {
        return averageScore;
    }

    public Double getTotalScore() {
        return totalScore;
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
