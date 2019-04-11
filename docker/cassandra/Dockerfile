FROM cassandra:latest

EXPOSE 7000 7001 7199 9042 9160

COPY docker/cassandra/docker-entrypoint.sh /docker-entrypoint.sh
RUN chmod a+x docker-entrypoint.sh

ADD https://datahub.io/sports-data/english-premier-league/r/0.csv docker-entrypoint-initdb.d/english-league/0.csv
ADD https://datahub.io/sports-data/english-premier-league/r/1.csv docker-entrypoint-initdb.d/english-league/1.csv
ADD https://datahub.io/sports-data/english-premier-league/r/2.csv docker-entrypoint-initdb.d/english-league/2.csv
ADD https://datahub.io/sports-data/english-premier-league/r/3.csv docker-entrypoint-initdb.d/english-league/3.csv
ADD https://datahub.io/sports-data/english-premier-league/r/4.csv docker-entrypoint-initdb.d/english-league/4.csv
ADD https://datahub.io/sports-data/english-premier-league/r/5.csv docker-entrypoint-initdb.d/english-league/5.csv
ADD https://datahub.io/sports-data/english-premier-league/r/6.csv docker-entrypoint-initdb.d/english-league/6.csv
ADD https://datahub.io/sports-data/english-premier-league/r/7.csv docker-entrypoint-initdb.d/english-league/7.csv
ADD https://datahub.io/sports-data/english-premier-league/r/8.csv docker-entrypoint-initdb.d/english-league/8.csv
ADD https://datahub.io/sports-data/english-premier-league/r/9.csv docker-entrypoint-initdb.d/english-league/9.csv
ADD https://datahub.io/sports-data/english-premier-league/r/10.csv docker-entrypoint-initdb.d/english-league/10.csv

ADD https://datahub.io/sports-data/spanish-la-liga/r/0.csv docker-entrypoint-initdb.d/spanish-league/0.csv
ADD https://datahub.io/sports-data/spanish-la-liga/r/1.csv docker-entrypoint-initdb.d/spanish-league/1.csv
ADD https://datahub.io/sports-data/spanish-la-liga/r/2.csv docker-entrypoint-initdb.d/spanish-league/2.csv
ADD https://datahub.io/sports-data/spanish-la-liga/r/3.csv docker-entrypoint-initdb.d/spanish-league/3.csv
ADD https://datahub.io/sports-data/spanish-la-liga/r/4.csv docker-entrypoint-initdb.d/spanish-league/4.csv
ADD https://datahub.io/sports-data/spanish-la-liga/r/5.csv docker-entrypoint-initdb.d/spanish-league/5.csv
ADD https://datahub.io/sports-data/spanish-la-liga/r/6.csv docker-entrypoint-initdb.d/spanish-league/6.csv
ADD https://datahub.io/sports-data/spanish-la-liga/r/7.csv docker-entrypoint-initdb.d/spanish-league/7.csv
ADD https://datahub.io/sports-data/spanish-la-liga/r/8.csv docker-entrypoint-initdb.d/spanish-league/8.csv
ADD https://datahub.io/sports-data/spanish-la-liga/r/9.csv docker-entrypoint-initdb.d/spanish-league/9.csv
ADD https://datahub.io/sports-data/spanish-la-liga/r/10.csv docker-entrypoint-initdb.d/spanish-league/10.csv
ADD https://datahub.io/sports-data/spanish-la-liga/r/11.csv docker-entrypoint-initdb.d/spanish-league/11.csv

ADD https://datahub.io/sports-data/italian-serie-a/r/0.csv docker-entrypoint-initdb.d/italian-league/0.csv
ADD https://datahub.io/sports-data/italian-serie-a/r/1.csv docker-entrypoint-initdb.d/italian-league/1.csv
ADD https://datahub.io/sports-data/italian-serie-a/r/2.csv docker-entrypoint-initdb.d/italian-league/2.csv
ADD https://datahub.io/sports-data/italian-serie-a/r/3.csv docker-entrypoint-initdb.d/italian-league/3.csv
ADD https://datahub.io/sports-data/italian-serie-a/r/4.csv docker-entrypoint-initdb.d/italian-league/4.csv
ADD https://datahub.io/sports-data/italian-serie-a/r/5.csv docker-entrypoint-initdb.d/italian-league/5.csv
ADD https://datahub.io/sports-data/italian-serie-a/r/6.csv docker-entrypoint-initdb.d/italian-league/6.csv
ADD https://datahub.io/sports-data/italian-serie-a/r/7.csv docker-entrypoint-initdb.d/italian-league/7.csv
ADD https://datahub.io/sports-data/italian-serie-a/r/8.csv docker-entrypoint-initdb.d/italian-league/8.csv
ADD https://datahub.io/sports-data/italian-serie-a/r/9.csv docker-entrypoint-initdb.d/italian-league/9.csv
ADD https://datahub.io/sports-data/italian-serie-a/r/10.csv docker-entrypoint-initdb.d/italian-league/10.csv
ADD https://datahub.io/sports-data/italian-serie-a/r/11.csv docker-entrypoint-initdb.d/italian-league/11.csv

ADD https://datahub.io/sports-data/german-bundesliga/r/0.csv docker-entrypoint-initdb.d/german-league/0.csv
ADD https://datahub.io/sports-data/german-bundesliga/r/1.csv docker-entrypoint-initdb.d/german-league/1.csv
ADD https://datahub.io/sports-data/german-bundesliga/r/2.csv docker-entrypoint-initdb.d/german-league/2.csv
ADD https://datahub.io/sports-data/german-bundesliga/r/3.csv docker-entrypoint-initdb.d/german-league/3.csv
ADD https://datahub.io/sports-data/german-bundesliga/r/4.csv docker-entrypoint-initdb.d/german-league/4.csv
ADD https://datahub.io/sports-data/german-bundesliga/r/5.csv docker-entrypoint-initdb.d/german-league/5.csv
ADD https://datahub.io/sports-data/german-bundesliga/r/6.csv docker-entrypoint-initdb.d/german-league/6.csv
ADD https://datahub.io/sports-data/german-bundesliga/r/7.csv docker-entrypoint-initdb.d/german-league/7.csv
ADD https://datahub.io/sports-data/german-bundesliga/r/8.csv docker-entrypoint-initdb.d/german-league/8.csv
ADD https://datahub.io/sports-data/german-bundesliga/r/9.csv docker-entrypoint-initdb.d/german-league/9.csv
ADD https://datahub.io/sports-data/german-bundesliga/r/10.csv docker-entrypoint-initdb.d/german-league/10.csv
ADD https://datahub.io/sports-data/german-bundesliga/r/11.csv docker-entrypoint-initdb.d/german-league/11.csv

ADD https://datahub.io/sports-data/french-ligue-1/r/0.csv docker-entrypoint-initdb.d/french-league/0.csv
ADD https://datahub.io/sports-data/french-ligue-1/r/1.csv docker-entrypoint-initdb.d/french-league/1.csv
ADD https://datahub.io/sports-data/french-ligue-1/r/2.csv docker-entrypoint-initdb.d/french-league/2.csv
ADD https://datahub.io/sports-data/french-ligue-1/r/3.csv docker-entrypoint-initdb.d/french-league/3.csv
ADD https://datahub.io/sports-data/french-ligue-1/r/4.csv docker-entrypoint-initdb.d/french-league/4.csv
ADD https://datahub.io/sports-data/french-ligue-1/r/5.csv docker-entrypoint-initdb.d/french-league/5.csv
ADD https://datahub.io/sports-data/french-ligue-1/r/6.csv docker-entrypoint-initdb.d/french-league/6.csv
ADD https://datahub.io/sports-data/french-ligue-1/r/7.csv docker-entrypoint-initdb.d/french-league/7.csv
ADD https://datahub.io/sports-data/french-ligue-1/r/8.csv docker-entrypoint-initdb.d/french-league/8.csv
ADD https://datahub.io/sports-data/french-ligue-1/r/9.csv docker-entrypoint-initdb.d/french-league/9.csv
ADD https://datahub.io/sports-data/french-ligue-1/r/10.csv docker-entrypoint-initdb.d/french-league/10.csv

COPY docker/cassandra/initial-seed.cql docker-entrypoint-initdb.d/initial-seed.cql
