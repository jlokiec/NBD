package com.footballstats.restapi.dao;

import com.datastax.driver.core.*;
import com.footballstats.restapi.cassandra.CassandraConnector;
import com.footballstats.restapi.model.GameEntity;
import com.footballstats.restapi.model.HomeAwaySum;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class GameEntityDao {
    private static final String TABLE_NAME = "european_league_results.game_results";
    private static final String UID = "uid";

    private Session session;

    public GameEntityDao() {
        CassandraConnector connector = new CassandraConnector();
        connector.connect();
        session = connector.getSession();
    }

    public UUID create(GameEntity gameEntity) {
        HomeAwaySum fullTimeGoals = gameEntity.getFullTimeGoals();
        HomeAwaySum halfTimeGoals = gameEntity.getHalfTimeGoals();
        HomeAwaySum shots = gameEntity.getShots();
        HomeAwaySum shotsOnTarget = gameEntity.getShotsOnTarget();
        HomeAwaySum fouls = gameEntity.getFouls();
        HomeAwaySum corners = gameEntity.getCorners();
        HomeAwaySum yellowCards = gameEntity.getYellowCards();
        HomeAwaySum redCards = gameEntity.getRedCards();

        UUID uid = UUID.randomUUID();

        String query = "insert into " + TABLE_NAME + " (uid, date, season, league, home_team, away_team, ft_home_goals, ft_away_goals, ft_sum_goals, ft_result, ht_home_goals, ht_away_goals, ht_sum_goals, ht_result, home_shots, away_shots, sum_shots, home_shots_target, away_shots_target, sum_shots_target, home_fouls, away_fouls, sum_fouls, home_corners, away_corners, sum_corners, home_yellow, away_yellow, sum_yellow, home_red, away_red, sum_red)";
        query += " values(" + uid.toString() + ", '" + gameEntity.getDate() + "', '" + gameEntity.getSeason() + "', '" + gameEntity.getLeague() + "', '" + gameEntity.getHomeTeam() + "', '" + gameEntity.getAwayTeam() + "', ";
        query += fullTimeGoals.getHome() + ", " + fullTimeGoals.getAway() + ", " + fullTimeGoals.getSum() + ", '" + gameEntity.getFullTimeResult() + "', ";
        query += halfTimeGoals.getHome() + ", " + halfTimeGoals.getAway() + ", " + halfTimeGoals.getSum() + ", '" + gameEntity.getHalfTimeResult() + "', ";
        query += shots.getHome() + ", " + shots.getAway() + ", " + shots.getSum() + ", ";
        query += shotsOnTarget.getHome() + ", " + shotsOnTarget.getAway() + ", " + shotsOnTarget.getSum() + ", ";
        query += fouls.getHome() + ", " + fouls.getAway() + ", " + fouls.getSum() + ", ";
        query += corners.getHome() + ", " + corners.getAway() + ", " + corners.getSum() + ", ";
        query += yellowCards.getHome() + ", " + yellowCards.getAway() + ", " + yellowCards.getSum() + ", ";
        query += redCards.getHome() + ", " + redCards.getAway() + ", " + redCards.getSum() + ");";

        session.execute(query);
        return uid;
    }

    public GameEntity read(String uid) {
        String query = "select * from " + TABLE_NAME + " where uid=:uid";
        PreparedStatement preparedStatement = session.prepare(query);
        BoundStatement boundStatement = preparedStatement.bind()
                .setUUID(UID, UUID.fromString(uid));

        ResultSet resultSet = session.execute(boundStatement);
        Row row = resultSet.one();

        GameEntity gameEntity = new GameEntity();
        gameEntity.setUid(row.getUUID("uid"));
        gameEntity.setDate(row.getDate("date").toString());
        gameEntity.setLeague(row.getString("league"));
        gameEntity.setSeason(row.getString("season"));
        gameEntity.setFullTimeResult(row.getString("ft_result"));
        gameEntity.setHalfTimeResult(row.getString("ht_result"));
        gameEntity.setHomeTeam(row.getString("home_team"));
        gameEntity.setAwayTeam(row.getString("away_team"));

        HomeAwaySum fullTimeGoals = new HomeAwaySum();
        fullTimeGoals.setHome(row.getDouble("ft_home_goals"));
        fullTimeGoals.setAway(row.getDouble("ft_away_goals"));
        fullTimeGoals.setSum(row.getDouble("ft_sum_goals"));
        gameEntity.setFullTimeGoals(fullTimeGoals);

        HomeAwaySum halfTimeGoals = new HomeAwaySum();
        halfTimeGoals.setHome(row.getDouble("ht_home_goals"));
        halfTimeGoals.setAway(row.getDouble("ht_away_goals"));
        halfTimeGoals.setSum(row.getDouble("ht_sum_goals"));
        gameEntity.setHalfTimeGoals(halfTimeGoals);

        HomeAwaySum shots = new HomeAwaySum();
        shots.setHome(row.getDouble("home_shots"));
        shots.setAway(row.getDouble("away_shots"));
        shots.setSum(row.getDouble("sum_shots"));
        gameEntity.setShots(shots);

        HomeAwaySum shotsOnTarget = new HomeAwaySum();
        shotsOnTarget.setHome(row.getDouble("home_shots_target"));
        shotsOnTarget.setAway(row.getDouble("away_shots_target"));
        shotsOnTarget.setSum(row.getDouble("sum_shots_target"));
        gameEntity.setShotsOnTarget(shotsOnTarget);

        HomeAwaySum fouls = new HomeAwaySum();
        fouls.setHome(row.getDouble("home_fouls"));
        fouls.setAway(row.getDouble("away_fouls"));
        fouls.setSum(row.getDouble("sum_fouls"));
        gameEntity.setFouls(fouls);

        HomeAwaySum corners = new HomeAwaySum();
        corners.setHome(row.getDouble("home_corners"));
        corners.setAway(row.getDouble("away_corners"));
        corners.setSum(row.getDouble("sum_corners"));
        gameEntity.setCorners(corners);

        HomeAwaySum yellowCards = new HomeAwaySum();
        yellowCards.setHome(row.getDouble("home_yellow"));
        yellowCards.setAway(row.getDouble("away_yellow"));
        yellowCards.setSum(row.getDouble("sum_yellow"));
        gameEntity.setYellowCards(yellowCards);

        HomeAwaySum redCards = new HomeAwaySum();
        redCards.setHome(row.getDouble("home_red"));
        redCards.setAway(row.getDouble("away_red"));
        redCards.setSum(row.getDouble("sum_red"));
        gameEntity.setRedCards(redCards);

        return gameEntity;
    }

    public void delete(String uid) {
        String query = "delete from " + TABLE_NAME + " where uid=:uid";
        PreparedStatement preparedStatement = session.prepare(query);
        BoundStatement boundStatement = preparedStatement.bind()
                .setUUID(UID, UUID.fromString(uid));

        session.execute(boundStatement);
    }
}
