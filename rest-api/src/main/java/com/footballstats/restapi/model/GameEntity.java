package com.footballstats.restapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class GameEntity {
    private UUID uid;
    private String date;
    private String league;
    private String season;

    @JsonProperty("ft_result")
    private String fullTimeResult;

    @JsonProperty("ht_result")
    private String halfTimeResult;

    @JsonProperty("home_team")
    private String homeTeam;

    @JsonProperty("away_team")
    private String awayTeam;

    @JsonProperty("ft_goals")
    private HomeAwaySum fullTimeGoals;

    @JsonProperty("ht_goals")
    private HomeAwaySum halfTimeGoals;

    private HomeAwaySum shots;

    @JsonProperty("shots_on_target")
    private HomeAwaySum shotsOnTarget;

    private HomeAwaySum fouls;
    private HomeAwaySum corners;

    @JsonProperty("yellow_cards")
    private HomeAwaySum yellowCards;

    @JsonProperty("red_cards")
    private HomeAwaySum redCards;

    public String getFullTimeResult() {
        return fullTimeResult;
    }

    public void setFullTimeResult(String fullTimeResult) {
        this.fullTimeResult = fullTimeResult;
    }

    public String getHalfTimeResult() {
        return halfTimeResult;
    }

    public void setHalfTimeResult(String halfTimeResult) {
        this.halfTimeResult = halfTimeResult;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public HomeAwaySum getFullTimeGoals() {
        return fullTimeGoals;
    }

    public void setFullTimeGoals(HomeAwaySum fullTimeGoals) {
        this.fullTimeGoals = fullTimeGoals;
    }

    public HomeAwaySum getHalfTimeGoals() {
        return halfTimeGoals;
    }

    public void setHalfTimeGoals(HomeAwaySum halfTimeGoals) {
        this.halfTimeGoals = halfTimeGoals;
    }

    public HomeAwaySum getShots() {
        return shots;
    }

    public void setShots(HomeAwaySum shots) {
        this.shots = shots;
    }

    public HomeAwaySum getShotsOnTarget() {
        return shotsOnTarget;
    }

    public void setShotsOnTarget(HomeAwaySum shotsOnTarget) {
        this.shotsOnTarget = shotsOnTarget;
    }

    public HomeAwaySum getFouls() {
        return fouls;
    }

    public void setFouls(HomeAwaySum fouls) {
        this.fouls = fouls;
    }

    public HomeAwaySum getCorners() {
        return corners;
    }

    public void setCorners(HomeAwaySum corners) {
        this.corners = corners;
    }

    public HomeAwaySum getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(HomeAwaySum yellowCards) {
        this.yellowCards = yellowCards;
    }

    public HomeAwaySum getRedCards() {
        return redCards;
    }

    public void setRedCards(HomeAwaySum redCards) {
        this.redCards = redCards;
    }
}
