package com.footballstats.restapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Data
public class GameEntity {
    private static final String DATE_FORMAT = "yyyy-MM-dd";

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

    public Date parseDate() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.parse(date);
    }
}
