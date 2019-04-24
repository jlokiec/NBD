package com.footballstats.restapi.model;

public class HomeAwaySum {
    private double home;
    private double away;
    private double sum;

    public HomeAwaySum() {
    }

    public HomeAwaySum(double home, double away, double sum) {
        this.home = home;
        this.away = away;
        this.sum = sum;
    }

    public double getHome() {
        return home;
    }

    public void setHome(double home) {
        this.home = home;
    }

    public double getAway() {
        return away;
    }

    public void setAway(double away) {
        this.away = away;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
