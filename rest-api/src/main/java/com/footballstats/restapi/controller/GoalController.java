package com.footballstats.restapi.controller;

import com.footballstats.restapi.dao.GoalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goals")
public class GoalController {
    private static final String LEAGUE = "league";
    private static final String SEASON = "season";
    private static final String TEAM = "team";
    private static final String LIMIT = "limit";

    private GoalDao dao;

    @Autowired
    GoalController(GoalDao dao) {
        this.dao = dao;
    }

    @GetMapping("/over_league/{" + LEAGUE + "}/{" + LIMIT + "}")
    public long getForLeague(@PathVariable(LEAGUE) String league,
                             @PathVariable(LIMIT) Double limit) {
        return dao.countGamesOverForLeague(league, limit);
    }

    @GetMapping("/over_league_season/{" + LEAGUE + "}/{" + SEASON + "}/{" + LIMIT + "}")
    public long getForLeagueAndSeason(@PathVariable(LEAGUE) String league,
                                      @PathVariable(SEASON) String season,
                                      @PathVariable(LIMIT) Double limit) {
        return dao.countGamesOverForLeagueAndSeason(league, season, limit);
    }

    @GetMapping("/over_season_team/{" + SEASON + "}/{" + TEAM + "}/{" + LIMIT + "}")
    public long getForSeasonAndTeam(@PathVariable(SEASON) String season,
                                    @PathVariable(TEAM) String team,
                                    @PathVariable(LIMIT) Double limit) {
        return dao.countGamesOverForSeasonAndTeam(season, team, limit);
    }
}
