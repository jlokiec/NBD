package com.footballstats.restapi.dao;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.footballstats.restapi.cassandra.CassandraConnector;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class GoalDao {
    private static final String TABLE_NAME = "european_league_results.game_results";
    private static final String SEASON = "season";
    private static final String TEAM = "team";

    @Resource(name = CassandraConnector.SESSION)
    private Session session;

    public long countGamesOverForLeague(String league, double limit) {
        String query = "select count(*) from " + TABLE_NAME + " where league='" + league + "' and ft_sum_goals > " + limit + " allow filtering;";
        ResultSet resultSet = session.execute(query);
        return resultSet.one().getLong(0);
    }

    public long countGamesOverForLeagueAndSeason(String league, String season, double limit) {
        String query = "select count(*) from " + TABLE_NAME + " where league='" + league + "' and season='" + season + "' and ft_sum_goals > " + limit + " allow filtering;";
        ResultSet resultSet = session.execute(query);
        return resultSet.one().getLong(0);
    }

    public long countGamesOverForSeasonAndTeam(String season, String team, double limit) {
        long countHome = countGamesWithGoalsOver(season, team, limit, true);
        long countAway = countGamesWithGoalsOver(season, team, limit, false);

        return countHome + countAway;
    }

    public long countGamesUnderForLeague(String league, double limit) {
        String query = "select count(*) from " + TABLE_NAME + " where league='" + league + "' and ft_sum_goals < " + limit + " allow filtering;";
        ResultSet resultSet = session.execute(query);
        return resultSet.one().getLong(0);
    }

    public long countGamesUnderForLeagueAndSeason(String league, String season, double limit) {
        String query = "select count(*) from " + TABLE_NAME + " where league='" + league + "' and season='" + season + "' and ft_sum_goals < " + limit + " allow filtering;";
        ResultSet resultSet = session.execute(query);
        return resultSet.one().getLong(0);
    }

    public long countGamesUnderForSeasonAndTeam(String season, String team, double limit) {
        long countHome = countGamesWithGoalsUnder(season, team, limit, true);
        long countAway = countGamesWithGoalsUnder(season, team, limit, false);

        return countHome + countAway;
    }

    private long countGamesWithGoalsOver(String season, String team, double limit, boolean homeTeam) {
        String query = "";
        if (homeTeam) {
            query = "select count(*) from " + TABLE_NAME + " where season=:season and home_team=:team and ft_sum_goals > " + limit + " allow filtering";
        } else {
            query = "select count(*) from " + TABLE_NAME + " where season=:season and away_team=:team and ft_sum_goals > " + limit + " allow filtering";
        }
        PreparedStatement preparedStatement = session.prepare(query);

        BoundStatement boundStatement = preparedStatement.bind()
                .setString(SEASON, season)
                .setString(TEAM, team);

        ResultSet resultSet = session.execute(boundStatement);
        return resultSet.one().getLong(0);
    }

    private long countGamesWithGoalsUnder(String season, String team, double limit, boolean homeTeam) {
        String query = "";
        if (homeTeam) {
            query = "select count(*) from " + TABLE_NAME + " where season=:season and home_team=:team and ft_sum_goals < " + limit + " allow filtering";
        } else {
            query = "select count(*) from " + TABLE_NAME + " where season=:season and away_team=:team and ft_sum_goals < " + limit + " allow filtering";
        }
        PreparedStatement preparedStatement = session.prepare(query);

        BoundStatement boundStatement = preparedStatement.bind()
                .setString(SEASON, season)
                .setString(TEAM, team);

        ResultSet resultSet = session.execute(boundStatement);
        return resultSet.one().getLong(0);
    }
}
