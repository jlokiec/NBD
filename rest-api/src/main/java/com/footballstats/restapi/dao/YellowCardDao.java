package com.footballstats.restapi.dao;

import com.datastax.driver.core.*;
import com.footballstats.restapi.cassandra.CassandraConnector;
import com.footballstats.restapi.dao.util.SumAndCount;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class YellowCardDao {
    private static final String TABLE_NAME = "european_league_results.game_results";
    private static final String SEASON = "season";
    private static final String TEAM = "team";

    @Resource(name = CassandraConnector.SESSION)
    private Session session;

    public double getAvgForSeasonAndTeam(String season, String team) {
        SumAndCount home = getYellowCardsSumAndCount(season, team, true);
        SumAndCount away = getYellowCardsSumAndCount(season, team, false);

        return (1.0 * (home.getSum() + away.getSum())) / (1.0 * (home.getCount() + away.getCount()));
    }

    public double getAvgForLeague(String league) {
        String query = "select avg(sum_yellow) from " + TABLE_NAME + " where league='" + league + "' allow filtering;";
        ResultSet resultSet = session.execute(query);
        return resultSet.one().getDouble(0);
    }

    public double getAvgForLeagueAndSeason(String league, String season) {
        String query = "select avg(sum_yellow) from " + TABLE_NAME + " where league='" + league + "' and season='" + season + "' allow filtering;";
        ResultSet resultSet = session.execute(query);
        return resultSet.one().getDouble(0);
    }

    private SumAndCount getYellowCardsSumAndCount(String season, String team, boolean homeTeam) {
        String query = "";
        if (homeTeam) {
            query = "select sum(sum_yellow), count(sum_yellow) from " + TABLE_NAME + " where season=:season and home_team=:team allow filtering";
        } else {
            query = "select sum(sum_yellow), count(sum_yellow) from " + TABLE_NAME + " where season=:season and away_team=:team allow filtering";
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
