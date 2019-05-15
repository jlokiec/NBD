FROM cassandra:latest

EXPOSE 7000 7001 7199 9042 9160

COPY docker/cassandra/seed/docker-entrypoint.sh /docker-entrypoint.sh
RUN chmod a+x docker-entrypoint.sh

COPY docker/cassandra/seed/initial-seed.cql docker-entrypoint-initdb.d/initial-seed.cql
