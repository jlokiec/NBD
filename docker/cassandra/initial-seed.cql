CREATE KEYSPACE IF NOT EXISTS european_league_results WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

USE european_league_results;

CREATE TABLE english_premier_league (
	Date DATE,
	HomeTeam TEXT,
	AwayTeam TEXT,
	FTHG INT,
	FTAG INT,
	FTR TEXT,
	HTHG INT,
	HTAG INT,
	HTR TEXT,
	Referee TEXT,
	HS INT,
	AS INT,
	HST INT,
	AST INT,
	HF INT,
	AF INT,
	HC INT,
	AC INT,
	HY INT,
	AY INT,
	HR INT,
	AR INT,
	PRIMARY KEY (Date, HomeTeam, AwayTeam)
);

COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/season-1819.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/season-1718.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/season-1617.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/season-1516.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/season-1415.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/season-1314.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/season-1213.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/season-1112.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/season-1011.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/season-0910.csv' WITH DELIMITER=',' AND HEADER=TRUE;
