package com.footballstats.restapi.controller;

import com.footballstats.restapi.dao.ResultDao;
import com.footballstats.restapi.dao.util.TeamResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/results")
public class ResultController {
    private static final String SEASON = "season";
    private static final String TEAM = "team";

    private ResultDao dao;

    @Autowired
    ResultController(ResultDao dao) {
        this.dao = dao;
    }

    @GetMapping(value = "/{" + TEAM + "}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TeamResults getForTeam(@PathVariable(TEAM) String team) {
        return dao.getTeamResults(team);
    }

    @GetMapping(value = "/{" + TEAM + "}/{" + SEASON + "}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TeamResults getForTeamAndSeason(@PathVariable(TEAM) String team,
                                           @PathVariable(SEASON) String season) {
        return dao.getTeamResults(team, season);
    }
}
