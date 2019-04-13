package com.footballstats.restapi.dao.util;

public class TeamResults {
    private long wins;
    private long draws;
    private long losses;

    public TeamResults(long wins, long draws, long losses) {
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
    }

    public long getWins() {
        return wins;
    }

    public void setWins(long wins) {
        this.wins = wins;
    }

    public long getDraws() {
        return draws;
    }

    public void setDraws(long draws) {
        this.draws = draws;
    }

    public long getLosses() {
        return losses;
    }

    public void setLosses(long losses) {
        this.losses = losses;
    }
}
