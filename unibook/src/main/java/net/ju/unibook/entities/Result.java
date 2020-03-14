package main.java.net.ju.unibook.entities;

public class Result {
    private Exam ssc;
    private Exam hsc;
    private String status;
    private boolean canParticipate;

    public Result(Exam ssc, Exam hsc) {
        this.ssc = ssc;
        this.hsc = hsc;
    }

    public Result(Exam ssc, Exam hsc, String status, boolean canParticipate) {
        this.ssc = ssc;
        this.hsc = hsc;
        this.status = status;
        this.canParticipate = canParticipate;
    }

    public Exam getSsc() {
        return ssc;
    }

    public void setSsc(Exam ssc) {
        this.ssc = ssc;
    }

    public Exam getHsc() {
        return hsc;
    }

    public void setHsc(Exam hsc) {
        this.hsc = hsc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCanParticipate() {
        return canParticipate;
    }

    public void setCanParticipate(boolean canParticipate) {
        this.canParticipate = canParticipate;
    }
}
