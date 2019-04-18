package com.footballstats.restapi.dao;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.footballstats.restapi.cassandra.CassandraConfiguration;
import com.footballstats.restapi.cassandra.PreparedStatementCache;
import com.footballstats.restapi.dao.util.GameResult;
import com.footballstats.restapi.dao.util.TeamResults;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ResultDao {
    private static final String SEASON = "season";
    private static final String RESULT = "result";
    private static final String TEAM = "team";

    private static final String COUNT_FOR_HOME_TEAM_RESULT = "select count(ft_result) from game_results where home_team=:team and ft_result=:result allow filtering";
    private static final String COUNT_FOR_AWAY_TEAM_RESULT = "select count(ft_result) from game_results where away_team=:team and ft_result=:result allow filtering";
    private static final String COUNT_FOR_HOME_TEAM_SEASON_RESULT = "select count(ft_result) from game_results where season=:season and home_team=:team and ft_result=:result allow filtering";
    private static final String COUNT_FOR_AWAY_TEAM_SEASON_RESULT = "select count(ft_result) from game_results where season=:season and away_team=:team and ft_result=:result allow filtering";

    @Resource(name = CassandraConfiguration.SESSION)
    private Session session;

    @Resource(name = CassandraConfiguration.STATEMENT_CACHE)
    private PreparedStatementCache statementCache;

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
        BoundStatement statement = null;

        if (homeTeam) {
            statement = statementCache.getCqlStatement(COUNT_FOR_HOME_TEAM_RESULT);
        } else {
            statement = statementCache.getCqlStatement(COUNT_FOR_AWAY_TEAM_RESULT);
        }

        statement.setString(TEAM, team);
        statement.setString(RESULT, result.getResult());
        ResultSet resultSet = session.execute(statement);

        return resultSet.one().getLong(0);
    }

    public long countTeamResults(String team, String season, GameResult result, boolean homeTeam) {
        BoundStatement statement = null;

        if (homeTeam) {
            statement = statementCache.getCqlStatement(COUNT_FOR_HOME_TEAM_SEASON_RESULT);
        } else {
            statement = statementCache.getCqlStatement(COUNT_FOR_AWAY_TEAM_SEASON_RESULT);
        }

        statement.setString(TEAM, team);
        statement.setString(SEASON, season);
        statement.setString(RESULT, result.getResult());
        ResultSet resultSet = session.execute(statement);

        return resultSet.one().getLong(0);
    }
}
