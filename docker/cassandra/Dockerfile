FROM cassandra:latest

EXPOSE 7000 7001 7199 9042 9160

COPY docker/cassandra/docker-entrypoint.sh /docker-entrypoint.sh
RUN chmod a+x docker-entrypoint.sh

COPY docker/cassandra/season-1819.csv  docker-entrypoint-initdb.d/english-league/season-1819.csv
COPY docker/cassandra/season-1718.csv  docker-entrypoint-initdb.d/english-league/season-1718.csv
COPY docker/cassandra/season-1617.csv  docker-entrypoint-initdb.d/english-league/season-1617.csv
COPY docker/cassandra/season-1516.csv  docker-entrypoint-initdb.d/english-league/season-1516.csv
COPY docker/cassandra/season-1415.csv  docker-entrypoint-initdb.d/english-league/season-1415.csv
COPY docker/cassandra/season-1314.csv  docker-entrypoint-initdb.d/english-league/season-1314.csv
COPY docker/cassandra/season-1213.csv  docker-entrypoint-initdb.d/english-league/season-1213.csv
COPY docker/cassandra/season-1112.csv  docker-entrypoint-initdb.d/english-league/season-1112.csv
COPY docker/cassandra/season-1011.csv  docker-entrypoint-initdb.d/english-league/season-1011.csv
COPY docker/cassandra/season-0910.csv  docker-entrypoint-initdb.d/english-league/season-0910.csv

COPY docker/cassandra/initial-seed.cql docker-entrypoint-initdb.d/initial-seed.cql
