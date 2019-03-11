package main.java.model;

import javax.sql.rowset.serial.SerialArray;
import java.io.Serializable;

public class Scores implements Serializable {
    private static long serialVersionUID=1l;
    private String subject;
    private Double score;
    public Scores(String subject,Double score) {
        this.subject=subject;
        this.score=score;
    }
    public Scores() {

    }

    public Double getScore() {
        return score;
    }

    public String getSubject() {
        return subject;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
