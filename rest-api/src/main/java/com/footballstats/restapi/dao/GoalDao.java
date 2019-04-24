package com.footballstats.restapi.dao;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.footballstats.restapi.cassandra.CassandraConfiguration;
import com.footballstats.restapi.cassandra.PreparedStatementCache;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class GoalDao {
    private static final String LEAGUE = "league";
    private static final String SEASON = "season";
    private static final String TEAM = "team";
    private static final String LIMIT = "goal_limit";

    private static final String COUNT_OVER_FOR_LEAGUE_LIMIT = "select count(*) from game_results where league=:league and ft_sum_goals>:goal_limit allow filtering";
    private static final String COUNT_OVER_FOR_LEAGUE_SEASON_LIMIT = "select count(*) from game_results where league=:league and season=:season and ft_sum_goals>:goal_limit allow filtering";
    private static final String COUNT_OVER_FOR_SEASON_HOME_TEAM_LIMIT = "select count(*) from game_results where season=:season and home_team=:team and ft_sum_goals>:goal_limit allow filtering";
    private static final String COUNT_OVER_FOR_SEASON_AWAY_TEAM_LIMIT = "select count(*) from game_results where season=:season and away_team=:team and ft_sum_goals>:goal_limit allow filtering";
    private static final String COUNT_UNDER_FOR_LEAGUE_LIMIT = "select count(*) from game_results where league=:league and ft_sum_goals<:goal_limit allow filtering";
    private static final String COUNT_UNDER_FOR_LEAGUE_SEASON_LIMIT = "select count(*) from game_results where league=:league and season=:season and ft_sum_goals<:goal_limit allow filtering";
    private static final String COUNT_UNDER_FOR_SEASON_HOME_TEAM_LIMIT = "select count(*) from game_results where season=:season and home_team=:team and ft_sum_goals<:goal_limit allow filtering";
    private static final String COUNT_UNDER_FOR_SEASON_AWAY_TEAM_LIMIT = "select count(*) from game_results where season=:season and away_team=:team and ft_sum_goals<:goal_limit allow filtering";

    @Resource(name = CassandraConfiguration.SESSION)
    private Session session;

    @Resource(name = CassandraConfiguration.STATEMENT_CACHE)
    private PreparedStatementCache statementCache;

    public long countGamesOverForLeague(String league, double limit) {
        BoundStatement statement = statementCache.getCqlStatement(COUNT_OVER_FOR_LEAGUE_LIMIT);
        statement.setString(LEAGUE, league);
        statement.setDouble(LIMIT, limit);
        ResultSet resultSet = session.execute(statement);

        return resultSet.one().getLong(0);
    }

    public long countGamesOverForLeagueAndSeason(String league, String season, double limit) {
        BoundStatement statement = statementCache.getCqlStatement(COUNT_OVER_FOR_LEAGUE_SEASON_LIMIT);
        statement.setString(LEAGUE, league);
        statement.setString(SEASON, season);
        statement.setDouble(LIMIT, limit);
        ResultSet resultSet = session.execute(statement);

        return resultSet.one().getLong(0);
    }

    public long countGamesOverForSeasonAndTeam(String season, String team, double limit) {
        long countHome = countGamesWithGoalsOver(season, team, limit, true);
        long countAway = countGamesWithGoalsOver(season, team, limit, false);

        return countHome + countAway;
    }

    public long countGamesUnderForLeague(String league, double limit) {
        BoundStatement statement = statementCache.getCqlStatement(COUNT_UNDER_FOR_LEAGUE_LIMIT);
        statement.setString(LEAGUE, league);
        statement.setDouble(LIMIT, limit);
        ResultSet resultSet = session.execute(statement);

        return resultSet.one().getLong(0);
    }

    public long countGamesUnderForLeagueAndSeason(String league, String season, double limit) {
        BoundStatement statement = statementCache.getCqlStatement(COUNT_UNDER_FOR_LEAGUE_SEASON_LIMIT);
        statement.setString(LEAGUE, league);
        statement.setString(SEASON, season);
        statement.setDouble(LIMIT, limit);
        ResultSet resultSet = session.execute(statement);

        return resultSet.one().getLong(0);
    }

    public long countGamesUnderForSeasonAndTeam(String season, String team, double limit) {
        long countHome = countGamesWithGoalsUnder(season, team, limit, true);
        long countAway = countGamesWithGoalsUnder(season, team, limit, false);

        return countHome + countAway;
    }

    private long countGamesWithGoalsOver(String season, String team, double limit, boolean homeTeam) {
        BoundStatement statement = null;

        if (homeTeam) {
            statement = statementCache.getCqlStatement(COUNT_OVER_FOR_SEASON_HOME_TEAM_LIMIT);
        } else {
            statement = statementCache.getCqlStatement(COUNT_OVER_FOR_SEASON_AWAY_TEAM_LIMIT);
        }

        statement.setString(SEASON, season);
        statement.setString(TEAM, team);
        statement.setDouble(LIMIT, limit);
        ResultSet resultSet = session.execute(statement);

        return resultSet.one().getLong(0);
    }

    private long countGamesWithGoalsUnder(String season, String team, double limit, boolean homeTeam) {
        BoundStatement statement = null;

        if (homeTeam) {
            statement = statementCache.getCqlStatement(COUNT_UNDER_FOR_SEASON_HOME_TEAM_LIMIT);
        } else {
            statement = statementCache.getCqlStatement(COUNT_UNDER_FOR_SEASON_AWAY_TEAM_LIMIT);
        }

        statement.setString(SEASON, season);
        statement.setString(TEAM, team);
        statement.setDouble(LIMIT, limit);
        ResultSet resultSet = session.execute(statement);

        return resultSet.one().getLong(0);
    }
}
