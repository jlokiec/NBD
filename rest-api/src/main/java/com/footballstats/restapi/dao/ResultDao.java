package com.footballstats.restapi.dao;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.footballstats.restapi.cassandra.CassandraConnector;
import com.footballstats.restapi.dao.util.GameResult;
import com.footballstats.restapi.dao.util.TeamResults;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ResultDao {
    private static final String TABLE_NAME = "european_league_results.game_results";
    private static final String SEASON = "season";
    private static final String RESULT = "result";
    private static final String TEAM = "team";

    @Resource(name = CassandraConnector.SESSION)
    private Session session;

    public TeamResults getTeamResults(String team) {
        long homeWins = countTeamResults(team, GameResult.HOME_WIN, true);
        long homeDraws = countTeamResults(team, GameResult.DRAW, true);
        long homeLosses = countTeamResults(team, GameResult.AWAY_WIN, true);
        long awayWins = countTeamResults(team, GameResult.AWAY_WIN, false);
        long awayDraws = countTeamResults(team, GameResult.DRAW, false);
        long awayLosses = countTeamResults(team, GameResult.HOME_WIN, false);

        long wins = homeWins + awayWins;
        long draws = homeDraws + awayDraws;
        long losses = homeLosses + awayLosses;

        return new TeamResults(wins, draws, losses);
    }

    public TeamResults getTeamResults(String team, String season) {
        long homeWins = countTeamResults(team, season, GameResult.HOME_WIN, true);
        long homeDraws = countTeamResults(team, season, GameResult.DRAW, true);
        long homeLosses = countTeamResults(team, season, GameResult.AWAY_WIN, true);
        long awayWins = countTeamResults(team, season, GameResult.AWAY_WIN, false);
        long awayDraws = countTeamResults(team, season, GameResult.DRAW, false);
        long awayLosses = countTeamResults(team, season, GameResult.HOME_WIN, false);

        long wins = homeWins + awayWins;
        long draws = homeDraws + awayDraws;
        long losses = homeLosses + awayLosses;

        return new TeamResults(wins, draws, losses);
    }

    public long countTeamResults(String team, GameResult result, boolean homeTeam) {
        String query = "";
        if (homeTeam) {
            query = "select count(ft_result) from " + TABLE_NAME + " where home_team=:team and ft_result=:result allow filtering";
        } else {
            query = "select count(ft_result) from " + TABLE_NAME + " where away_team=:team and ft_result=:result allow filtering";
        }
        PreparedStatement preparedStatement = session.prepare(query);

        BoundStatement boundStatement = preparedStatement.bind()
                .setString(TEAM, team)
                .setString(RESULT, result.getResult());

        ResultSet resultSet = session.execute(boundStatement);
        return resultSet.one().getLong(0);
    }

    public long countTeamResults(String team, String season, GameResult result, boolean homeTeam) {
        String query = "";
        if (homeTeam) {
            query = "select count(ft_result) from " + TABLE_NAME + " where season=:season and home_team=:team and ft_result=:result allow filtering";
        } else {
            query = "select count(ft_result) from " + TABLE_NAME + " where season=:season and away_team=:team and ft_result=:result allow filtering";
        }
        PreparedStatement preparedStatement = session.prepare(query);

        BoundStatement boundStatement = preparedStatement.bind()
                .setString(SEASON, season)
                .setString(TEAM, team)
                .setString(RESULT, result.getResult());

        ResultSet resultSet = session.execute(boundStatement);
        return resultSet.one().getLong(0);
    }
}
