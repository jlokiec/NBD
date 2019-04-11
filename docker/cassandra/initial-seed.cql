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

CREATE TABLE spanish_la_liga (
	Date DATE,
	HomeTeam TEXT,
	AwayTeam TEXT,
	FTHG INT,
	FTAG INT,
	FTR TEXT,
	HTHG INT,
	HTAG INT,
	HTR TEXT,
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


CREATE TABLE italian_serie_a (
	Date DATE,
	HomeTeam TEXT,
	AwayTeam TEXT,
	FTHG INT,
	FTAG INT,
	FTR TEXT,
	HTHG INT,
	HTAG INT,
	HTR TEXT,
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


CREATE TABLE german_bundesliga (
	Date DATE,
	HomeTeam TEXT,
	AwayTeam TEXT,
	FTHG INT,
	FTAG INT,
	FTR TEXT,
	HTHG INT,
	HTAG INT,
	HTR TEXT,
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


CREATE TABLE french_ligue_1 (
	Date DATE,
	HomeTeam TEXT,
	AwayTeam TEXT,
	FTHG INT,
	FTAG INT,
	FTR TEXT,
	HTHG INT,
	HTAG INT,
	HTR TEXT,
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


COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/0.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/1.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/2.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/3.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/4.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/5.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/6.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/7.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/8.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/9.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY english_premier_league (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, Referee, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/english-league/10.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY spanish_la_liga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/spanish-league/0.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY spanish_la_liga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/spanish-league/1.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY spanish_la_liga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/spanish-league/2.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY spanish_la_liga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/spanish-league/3.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY spanish_la_liga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/spanish-league/4.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY spanish_la_liga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/spanish-league/5.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY spanish_la_liga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/spanish-league/6.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY spanish_la_liga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/spanish-league/7.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY spanish_la_liga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/spanish-league/8.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY spanish_la_liga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/spanish-league/9.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY spanish_la_liga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/spanish-league/10.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY spanish_la_liga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/spanish-league/11.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY italian_serie_a (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/italian-league/0.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY italian_serie_a (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/italian-league/1.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY italian_serie_a (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/italian-league/2.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY italian_serie_a (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/italian-league/3.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY italian_serie_a (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/italian-league/4.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY italian_serie_a (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/italian-league/5.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY italian_serie_a (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/italian-league/6.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY italian_serie_a (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/italian-league/7.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY italian_serie_a (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/italian-league/8.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY italian_serie_a (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/italian-league/9.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY italian_serie_a (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/italian-league/10.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY italian_serie_a (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/italian-league/11.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY german_bundesliga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/german-league/0.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY german_bundesliga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/german-league/1.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY german_bundesliga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/german-league/2.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY german_bundesliga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/german-league/3.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY german_bundesliga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/german-league/4.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY german_bundesliga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/german-league/5.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY german_bundesliga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/german-league/6.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY german_bundesliga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/german-league/7.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY german_bundesliga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/german-league/8.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY german_bundesliga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/german-league/9.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY german_bundesliga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/german-league/10.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY german_bundesliga (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/german-league/11.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY french_ligue_1 (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/french-league/0.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY french_ligue_1 (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/french-league/1.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY french_ligue_1 (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/french-league/2.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY french_ligue_1 (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/french-league/3.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY french_ligue_1 (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/french-league/4.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY french_ligue_1 (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/french-league/5.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY french_ligue_1 (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/french-league/6.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY french_ligue_1 (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/french-league/7.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY french_ligue_1 (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/french-league/8.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY french_ligue_1 (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/french-league/9.csv' WITH DELIMITER=',' AND HEADER=TRUE;

COPY french_ligue_1 (Date, HomeTeam, AwayTeam, FTHG, FTAG, FTR, HTHG, HTAG, HTR, HS, AS, HST, AST, HF, AF, HC, AC, HY, AY, HR, AR) FROM '/docker-entrypoint-initdb.d/french-league/10.csv' WITH DELIMITER=',' AND HEADER=TRUE;

