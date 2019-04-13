package com.footballstats.restapi.controller;

import com.footballstats.restapi.dao.ShotDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shots")
public class ShotController {
    private static final String LEAGUE = "league";
    private static final String SEASON = "season";
    private static final String TEAM = "team";

    private ShotDao dao;

    @Autowired
    ShotController(ShotDao dao) {
        this.dao = dao;
    }

    @GetMapping("/avg_league/{" + LEAGUE + "}")
    public double getAvgForLeague(@PathVariable(LEAGUE) String league) {
        return dao.getAvgShots(league);
    }

    @GetMapping("/avg_league_season/{" + LEAGUE + "}/{" + SEASON + "}")
    public double getAvgForLeagueAndSeason(@PathVariable(LEAGUE) String league,
                                           @PathVariable(SEASON) String season) {
        return dao.getAvgShots(league, season);
    }

    @GetMapping("/avg_league_season_game/{" + LEAGUE + "}/{" + SEASON + "}/{" + TEAM + "}")
    public double getAvgForLeagueSeasonAndTeam(@PathVariable(LEAGUE) String league,
                                               @PathVariable(SEASON) String season,
                                               @PathVariable(TEAM) String team) {
        return dao.getAvgShots(league, season, team);
    }
}
