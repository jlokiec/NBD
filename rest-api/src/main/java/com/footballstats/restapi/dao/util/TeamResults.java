package com.footballstats.restapi.dao.util;

import lombok.Data;

@Data
public class TeamResults {
    private long wins;
    private long draws;
    private long losses;

    public TeamResults(long wins, long draws, long losses) {
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
    }
}
