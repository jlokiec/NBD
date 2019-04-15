CREATE KEYSPACE IF NOT EXISTS european_league_results WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

USE european_league_results;

CREATE TABLE game_results (
	uid UUID primary key,
	date DATE,
	season TEXT,
	league TEXT,
	home_team TEXT,
	away_team TEXT,
	ft_home_goals DOUBLE,
	ft_away_goals DOUBLE,
	ft_sum_goals DOUBLE,
	ft_result TEXT,
	ht_home_goals DOUBLE,
	ht_away_goals DOUBLE,
	ht_sum_goals DOUBLE,
	ht_result TEXT,
	home_shots DOUBLE,
	away_shots DOUBLE,
	sum_shots DOUBLE,
	home_shots_target DOUBLE,
	away_shots_target DOUBLE,
	sum_shots_target DOUBLE,
	home_fouls DOUBLE,
	away_fouls DOUBLE,
	sum_fouls DOUBLE,
	home_corners DOUBLE,
	away_corners DOUBLE,
	sum_corners DOUBLE,
	home_yellow DOUBLE,
	away_yellow DOUBLE,
	sum_yellow DOUBLE,
	home_red DOUBLE,
	away_red DOUBLE,
	sum_red DOUBLE
);