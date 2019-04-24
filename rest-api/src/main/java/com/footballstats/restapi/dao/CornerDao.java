package com.footballstats.restapi.dao;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.footballstats.restapi.cassandra.CassandraConfiguration;
import com.footballstats.restapi.cassandra.PreparedStatementCache;
import com.footballstats.restapi.dao.util.SumAndCount;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class CornerDao {
    private static final String LEAGUE = "league";
    private static final String SEASON = "season";
    private static final String TEAM = "team";

    private static final String AVG_FOR_LEAGUE = "select avg(sum_corners) from game_results where league=:league allow filtering";
    private static final String AVG_FOR_LEAGUE_SEASON = "select avg(sum_corners) from game_results where league=:league and season=:season allow filtering";
    private static final String SUM_COUNT_FOR_SEASON_HOME_TEAM = "select sum(sum_corners), count(sum_corners) from game_results where season=:season and home_team=:team allow filtering";
    private static final String SUM_COUNT_FOR_SEASON_AWAY_TEAM = "select sum(sum_corners), count(sum_corners) from game_results where season=:season and away_team=:team allow filtering";

    @Resource(name = CassandraConfiguration.SESSION)
    private Session session;

    @Resource(name = CassandraConfiguration.STATEMENT_CACHE)
    private PreparedStatementCache statementCache;

    public double getAvgForSeasonAndTeam(String season, String team) {
        SumAndCount home = getCornersSumAndCount(season, team, true);
        SumAndCount away = getCornersSumAndCount(season, team, false);

        return (1.0 * (home.getSum() + away.getSum())) / (1.0 * (home.getCount() + away.getCount()));
    }

    public double getAvgForLeague(String league) {
        BoundStatement statement = statementCache.getCqlStatement(AVG_FOR_LEAGUE);
        statement.setString(LEAGUE, league);
        ResultSet resultSet = session.execute(statement);

        return resultSet.one().getDouble(0);
    }

    public double getAvgForLeagueAndSeason(String league, String season) {
        BoundStatement statement = statementCache.getCqlStatement(AVG_FOR_LEAGUE_SEASON);
        statement.setString(LEAGUE, league);
        statement.setString(SEASON, season);
        ResultSet resultSet = session.execute(statement);

        return resultSet.one().getDouble(0);
    }

    private SumAndCount getCornersSumAndCount(String season, String team, boolean homeTeam) {
        BoundStatement statement = null;

        if (homeTeam) {
            statement = statementCache.getCqlStatement(SUM_COUNT_FOR_SEASON_HOME_TEAM);
        } else {
            statement = statementCache.getCqlStatement(SUM_COUNT_FOR_SEASON_AWAY_TEAM);
        }

        statement.setString(SEASON, season);
        statement.setString(TEAM, team);

        ResultSet resultSet = session.execute(statement);
        Row row = resultSet.one();
        double sum = row.getDouble(0);
        long count = row.getLong(1);

        return new SumAndCount(sum, count);
    }
}
