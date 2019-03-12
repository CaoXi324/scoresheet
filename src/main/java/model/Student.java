package main.java.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
        this.totalScore=scores.stream().map(ele->ele.getScore()).reduce(0.0,(a,b)->a+b);
        this.averageScore=totalScore/scores.size();


    }

    public Student() {

    }

    public void setAverageScore(ArrayList<Scores> scores) {
        this.averageScore=totalScore/scores.size();


    }

    public void setTotalScore(ArrayList<Scores> scores) {
        Double totalScore=0.0;
        for(Scores score:scores){
            totalScore+=score.getScore();
        }
        this.totalScore = totalScore;

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
