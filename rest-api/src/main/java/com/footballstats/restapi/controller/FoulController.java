package com.footballstats.restapi.controller;

import com.footballstats.restapi.dao.FoulDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fouls")
public class FoulController {
    private static final String LEAGUE = "league";
    private static final String SEASON = "season";
    private static final String TEAM = "team";

    private FoulDao dao;

    @Autowired
    FoulController(FoulDao dao) {
        this.dao = dao;
    }

    @GetMapping("/avg_league/{" + LEAGUE + "}")
    public double getAvgForLeague(@PathVariable(LEAGUE) String league) {
        return dao.getAvgFouls(league);
    }

    @GetMapping("/avg_league_season/{" + LEAGUE + "}/{" + SEASON + "}")
    public double getAvgForLeagueAndSeason(@PathVariable(LEAGUE) String league,
                                           @PathVariable(SEASON) String season) {
        return dao.getAvgFouls(league, season);
    }

    @GetMapping("/avg_league_season_game/{" + LEAGUE + "}/{" + SEASON + "}/{" + TEAM + "}")
    public double getAvgForLeagueSeasonAndTeam(@PathVariable(LEAGUE) String league,
                                               @PathVariable(SEASON) String season,
                                               @PathVariable(TEAM) String team) {
        return dao.getAvgFouls(league, season, team);
    }
}