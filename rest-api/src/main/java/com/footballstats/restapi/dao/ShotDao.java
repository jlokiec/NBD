package com.footballstats.restapi.dao;

import com.datastax.driver.core.*;
import com.footballstats.restapi.cassandra.CassandraConnector;
import com.footballstats.restapi.dao.util.SumAndCount;
import org.springframework.stereotype.Repository;

@Repository
public class ShotDao {
    private static final String TABLE_NAME = "european_league_results.game_results";
    private static final String SEASON = "season";
    private static final String TEAM = "team";

    private Session session;

    public ShotDao() {
        CassandraConnector connector = new CassandraConnector();
        connector.connect();
        session = connector.getSession();
    }

    public double getAvgForSeasonAndTeam(String season, String team) {
        SumAndCount home = getShotsSumAndCount(season, team, true);
        SumAndCount away = getShotsSumAndCount(season, team, false);

        return (1.0 * (home.getSum() + away.getSum())) / (1.0 * (home.getCount() + away.getCount()));
    }

    public double getAvgForLeague(String league) {
        String query = "select avg(sum_shots) from " + TABLE_NAME + " where league='" + league + "' allow filtering;";
        ResultSet resultSet = session.execute(query);
        return resultSet.one().getDouble(0);
    }

    public double getAvgForLeagueAndSeason(String league, String season) {
        String query = "select avg(sum_shots) from " + TABLE_NAME + " where league='" + league + "' and season='" + season + "' allow filtering;";
        ResultSet resultSet = session.execute(query);
        return resultSet.one().getDouble(0);
    }

    private SumAndCount getShotsSumAndCount(String season, String team, boolean homeTeam) {
        String query = "";
        if (homeTeam) {
            query = "select sum(sum_shots), count(sum_shots) from " + TABLE_NAME + " where season=:season and and home_team=:team allow filtering";
        } else {
            query = "select sum(sum_shots), count(sum_shots) from " + TABLE_NAME + " where season=:season and away_team=:team allow filtering";
        }
        PreparedStatement preparedStatement = session.prepare(query);

        BoundStatement boundStatement = preparedStatement.bind()
                .setString(SEASON, season)
                .setString(TEAM, team);

        ResultSet resultSet = session.execute(boundStatement);
        Row row = resultSet.one();
        double sum = row.getDouble(0);
        long count = row.getLong(1);
        return new SumAndCount(sum, count);
    }
}
