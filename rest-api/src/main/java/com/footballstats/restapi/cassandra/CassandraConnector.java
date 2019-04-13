package com.footballstats.restapi.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CassandraConnector {
    private static final String NODE_ADDRESS = "localhost";
    private static final int PORT = 9042;

    private Cluster cluster;
    private Session session;

    public void connect() {
        Cluster.Builder b = Cluster.builder()
                .withoutJMXReporting()
                .addContactPoint(NODE_ADDRESS);

        b.withPort(PORT);
        cluster = b.build();
        session = cluster.connect();
    }

    public Session getSession() {
        return this.session;
    }

    public void close() {
        session.close();
        cluster.close();
    }
}
