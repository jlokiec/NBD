package com.footballstats.restapi.dao.util;

public enum GameResult {
    HOME_WIN("H"), DRAW("D"), AWAY_WIN("A");

    private String result;

    GameResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
