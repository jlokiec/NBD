package com.footballstats.restapi.model;

import lombok.Data;

@Data
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
}
