FROM cassandra:latest

EXPOSE 7000 7001 7199 9042 9160

COPY docker/cassandra/node/docker-entrypoint.sh /docker-entrypoint.sh
RUN chmod a+x docker-entrypoint.sh
