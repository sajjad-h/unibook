package main.java.net.ju.unibook.entities;

public class Age {
    private int years;
    private int months;
    private int days;
    private long totalDays;
    private long totalSeconds;

    public Age(int years, int months, int days, long totalDays, long totalSeconds) {
        this.years = years;
        this.months = months;
        this.days = days;
        this.totalDays = totalDays;
        this.totalSeconds = totalSeconds;
    }

    public Age(int years) {
        this.years = years;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public long getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(long totalDays) {
        this.totalDays = totalDays;
    }

    public long getTotalSeconds() {
        return totalSeconds;
    }

    public void setTotalSeconds(long totalSeconds) {
        this.totalSeconds = totalSeconds;
    }
}
