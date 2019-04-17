package com.footballstats.restapi.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CassandraConnector {
    public static final String SESSION = "session";

    private static final String NODE_ADDRESS = "localhost";
    private static final int PORT = 9042;

    private Session session;
    private boolean initialized = false;

    private void connect() {
        Cluster.Builder b = Cluster.builder()
                .withoutJMXReporting()
                .addContactPoint(NODE_ADDRESS);

        b.withPort(PORT);
        Cluster cluster = b.build();
        session = cluster.connect();
    }

    @Bean(name = SESSION)
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Session getSession() {
        if (!initialized) {
            connect();
            initialized = true;
        }
        return session;
    }
}
