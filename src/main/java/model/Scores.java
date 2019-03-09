package main.java.model;

public class Scores {
    private String subject;
    private String score;
    public Scores(String subject,String score) {
        this.subject=subject;
        this.score=score;
    }

    public String getScore() {
        return score;
    }

    public String getSubject() {
        return subject;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
