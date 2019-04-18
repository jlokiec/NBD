package com.footballstats.restapi.dao;

import com.datastax.driver.core.*;
import com.footballstats.restapi.cassandra.CassandraConfiguration;
import com.footballstats.restapi.cassandra.PreparedStatementCache;
import com.footballstats.restapi.model.GameEntity;
import com.footballstats.restapi.model.HomeAwaySum;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Calendar;
import java.util.UUID;

@Repository
public class GameEntityDao {
    private static final String UID = "uid";
    private static final String DATE = "date";
    private static final String SEASON = "season";
    private static final String LEAGUE = "league";
    private static final String HOME_TEAM = "home_team";
    private static final String AWAY_TEAM = "away_team";
    private static final String FT_HOME_GOALS = "ft_home_goals";
    private static final String FT_AWAY_GOALS = "ft_away_goals";
    private static final String FT_SUM_GOALS = "ft_sum_goals";
    private static final String FT_RESULT = "ft_result";
    private static final String HT_HOME_GOALS = "ht_home_goals";
    private static final String HT_AWAY_GOALS = "ht_away_goals";
    private static final String HT_SUM_GOALS = "ht_sum_goals";
    private static final String HT_RESULT = "ht_result";
    private static final String HOME_SHOTS = "home_shots";
    private static final String AWAY_SHOTS = "away_shots";
    private static final String SUM_SHOTS = "sum_shots";
    private static final String HOME_SHOTS_TARGET = "home_shots_target";
    private static final String AWAY_SHOTS_TARGET = "away_shots_target";
    private static final String SUM_SHOTS_TARGET = "sum_shots_target";
    private static final String HOME_FOULS = "home_fouls";
    private static final String AWAY_FOULS = "away_fouls";
    private static final String SUM_FOULS = "sum_fouls";
    private static final String HOME_CORNERS = "home_corners";
    private static final String AWAY_CORNERS = "away_corners";
    private static final String SUM_CORNERS = "sum_corners";
    private static final String HOME_YELLOW = "home_yellow";
    private static final String AWAY_YELLOW = "away_yellow";
    private static final String SUM_YELLOW = "sum_yellow";
    private static final String HOME_RED = "home_red";
    private static final String AWAY_RED = "away_red";
    private static final String SUM_RED = "sum_red";

    private static final String INSERT = "insert into game_results (uid, date, season, league, home_team, away_team, " +
            "ft_home_goals, ft_away_goals, ft_sum_goals, ft_result, ht_home_goals, ht_away_goals, ht_sum_goals, " +
            "ht_result, home_shots, away_shots, sum_shots, home_shots_target, away_shots_target, sum_shots_target, " +
            "home_fouls, away_fouls, sum_fouls, home_corners, away_corners, sum_corners, home_yellow, away_yellow, " +
            "sum_yellow, home_red, away_red, sum_red) values(:uid, :date, :season, :league, :home_team, :away_team, " +
            ":ft_home_goals, :ft_away_goals, :ft_sum_goals, :ft_result, :ht_home_goals, :ht_away_goals, " +
            ":ht_sum_goals, :ht_result, :home_shots, :away_shots, :sum_shots, :home_shots_target, :away_shots_target, " +
            ":sum_shots_target, :home_fouls, :away_fouls, :sum_fouls, :home_corners, :away_corners, :sum_corners, " +
            ":home_yellow, :away_yellow, :sum_yellow, :home_red, :away_red, :sum_red)";
    private static final String UPDATE = "update game_results set date=:date, season=:season, league=:league, " +
            "home_team=:home_team, away_team=:away_team, ft_home_goals=:ft_home_goals, ft_away_goals=:ft_away_goals, " +
            "ft_sum_goals=:ft_sum_goals, ft_result=:ft_result, ht_home_goals=:ht_home_goals, " +
            "ht_away_goals=:ht_away_goals, ht_sum_goals=:ht_sum_goals, ht_result=:ht_result, home_shots=:home_shots, " +
            "away_shots=:away_shots, sum_shots=:sum_shots, home_shots_target=:home_shots_target, " +
            "away_shots_target=:away_shots_target, sum_shots_target=:sum_shots_target, home_fouls=:home_fouls, " +
            "away_fouls=:away_fouls, sum_fouls=:sum_fouls, home_corners=:home_corners, away_corners=:away_corners, " +
            "sum_corners=:sum_corners, home_yellow=:home_yellow, away_yellow=:away_yellow, sum_yellow=:sum_yellow, " +
            "home_red=:home_red, away_red=:away_red, sum_red=:sum_red where uid=:uid";
    private static final String DELETE = "delete from game_results where uid=:uid";
    private static final String SELECT = "select uid, date, season, league, home_team, away_team, ft_home_goals, " +
            "ft_away_goals, ft_sum_goals, ft_result, ht_home_goals, ht_away_goals, ht_sum_goals, ht_result, " +
            "home_shots, away_shots, sum_shots, home_shots_target, away_shots_target, sum_shots_target, home_fouls, " +
            "away_fouls, sum_fouls, home_corners, away_corners, sum_corners, home_yellow, away_yellow, sum_yellow, " +
            "home_red, away_red, sum_red from game_results where uid=:uid";

    @Resource(name = CassandraConfiguration.SESSION)
    private Session session;

    @Resource(name = CassandraConfiguration.STATEMENT_CACHE)
    private PreparedStatementCache statementCache;

    public UUID create(GameEntity gameEntity) {
        UUID uid = UUID.randomUUID();
        LocalDate localDate = null;

        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(gameEntity.parseDate());
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            localDate = LocalDate.fromYearMonthDay(year, month, day);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        BoundStatement statement = statementCache.getCqlStatement(INSERT);
        statement.setUUID(UID, uid);
        statement.setDate(DATE, localDate);
        statement.setString(SEASON, gameEntity.getSeason());
        statement.setString(LEAGUE, gameEntity.getLeague());
        statement.setString(HOME_TEAM, gameEntity.getHomeTeam());
        statement.setString(AWAY_TEAM, gameEntity.getAwayTeam());

        statement.setDouble(FT_HOME_GOALS, gameEntity.getFullTimeGoals().getHome());
        statement.setDouble(FT_AWAY_GOALS, gameEntity.getFullTimeGoals().getAway());
        statement.setDouble(FT_SUM_GOALS, gameEntity.getFullTimeGoals().getSum());
        statement.setString(FT_RESULT, gameEntity.getFullTimeResult());

        statement.setDouble(HT_HOME_GOALS, gameEntity.getHalfTimeGoals().getHome());
        statement.setDouble(HT_AWAY_GOALS, gameEntity.getHalfTimeGoals().getAway());
        statement.setDouble(HT_SUM_GOALS, gameEntity.getHalfTimeGoals().getSum());
        statement.setString(HT_RESULT, gameEntity.getHalfTimeResult());

        statement.setDouble(HOME_SHOTS, gameEntity.getShots().getHome());
        statement.setDouble(AWAY_SHOTS, gameEntity.getShots().getAway());
        statement.setDouble(SUM_SHOTS, gameEntity.getShots().getSum());

        statement.setDouble(HOME_SHOTS_TARGET, gameEntity.getShotsOnTarget().getHome());
        statement.setDouble(AWAY_SHOTS_TARGET, gameEntity.getShotsOnTarget().getAway());
        statement.setDouble(SUM_SHOTS_TARGET, gameEntity.getShotsOnTarget().getSum());

        statement.setDouble(HOME_FOULS, gameEntity.getFouls().getHome());
        statement.setDouble(AWAY_FOULS, gameEntity.getFouls().getAway());
        statement.setDouble(SUM_FOULS, gameEntity.getFouls().getSum());

        statement.setDouble(HOME_CORNERS, gameEntity.getCorners().getHome());
        statement.setDouble(AWAY_CORNERS, gameEntity.getCorners().getAway());
        statement.setDouble(SUM_CORNERS, gameEntity.getCorners().getSum());

        statement.setDouble(HOME_YELLOW, gameEntity.getYellowCards().getHome());
        statement.setDouble(AWAY_YELLOW, gameEntity.getYellowCards().getAway());
        statement.setDouble(SUM_YELLOW, gameEntity.getYellowCards().getSum());

        statement.setDouble(HOME_RED, gameEntity.getRedCards().getHome());
        statement.setDouble(AWAY_RED, gameEntity.getRedCards().getAway());
        statement.setDouble(SUM_RED, gameEntity.getRedCards().getSum());

        session.execute(statement);
        return uid;
    }

    public GameEntity read(String uid) {
        BoundStatement statement = statementCache.getCqlStatement(SELECT);
        statement.setUUID(UID, UUID.fromString(uid));
        ResultSet resultSet = session.execute(statement);
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

    public GameEntity update(String uid, GameEntity gameEntity) {
        LocalDate localDate = null;

        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(gameEntity.parseDate());
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            localDate = LocalDate.fromYearMonthDay(year, month, day);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        BoundStatement statement = statementCache.getCqlStatement(UPDATE);
        statement.setUUID(UID, UUID.fromString(uid));
        statement.setDate(DATE, localDate);
        statement.setString(SEASON, gameEntity.getSeason());
        statement.setString(LEAGUE, gameEntity.getLeague());
        statement.setString(HOME_TEAM, gameEntity.getHomeTeam());
        statement.setString(AWAY_TEAM, gameEntity.getAwayTeam());

        statement.setDouble(FT_HOME_GOALS, gameEntity.getFullTimeGoals().getHome());
        statement.setDouble(FT_AWAY_GOALS, gameEntity.getFullTimeGoals().getAway());
        statement.setDouble(FT_SUM_GOALS, gameEntity.getFullTimeGoals().getSum());
        statement.setString(FT_RESULT, gameEntity.getFullTimeResult());

        statement.setDouble(HT_HOME_GOALS, gameEntity.getHalfTimeGoals().getHome());
        statement.setDouble(HT_AWAY_GOALS, gameEntity.getHalfTimeGoals().getAway());
        statement.setDouble(HT_SUM_GOALS, gameEntity.getHalfTimeGoals().getSum());
        statement.setString(HT_RESULT, gameEntity.getHalfTimeResult());

        statement.setDouble(HOME_SHOTS, gameEntity.getShots().getHome());
        statement.setDouble(AWAY_SHOTS, gameEntity.getShots().getAway());
        statement.setDouble(SUM_SHOTS, gameEntity.getShots().getSum());

        statement.setDouble(HOME_SHOTS_TARGET, gameEntity.getShotsOnTarget().getHome());
        statement.setDouble(AWAY_SHOTS_TARGET, gameEntity.getShotsOnTarget().getAway());
        statement.setDouble(SUM_SHOTS_TARGET, gameEntity.getShotsOnTarget().getSum());

        statement.setDouble(HOME_FOULS, gameEntity.getFouls().getHome());
        statement.setDouble(AWAY_FOULS, gameEntity.getFouls().getAway());
        statement.setDouble(SUM_FOULS, gameEntity.getFouls().getSum());

        statement.setDouble(HOME_CORNERS, gameEntity.getCorners().getHome());
        statement.setDouble(AWAY_CORNERS, gameEntity.getCorners().getAway());
        statement.setDouble(SUM_CORNERS, gameEntity.getCorners().getSum());

        statement.setDouble(HOME_YELLOW, gameEntity.getYellowCards().getHome());
        statement.setDouble(AWAY_YELLOW, gameEntity.getYellowCards().getAway());
        statement.setDouble(SUM_YELLOW, gameEntity.getYellowCards().getSum());

        statement.setDouble(HOME_RED, gameEntity.getRedCards().getHome());
        statement.setDouble(AWAY_RED, gameEntity.getRedCards().getAway());
        statement.setDouble(SUM_RED, gameEntity.getRedCards().getSum());

        session.execute(statement);
        return read(uid);
    }

    public void delete(String uid) {
        BoundStatement statement = statementCache.getCqlStatement(DELETE);
        statement.setUUID(UID, UUID.fromString(uid));
        session.execute(statement);
    }
}
