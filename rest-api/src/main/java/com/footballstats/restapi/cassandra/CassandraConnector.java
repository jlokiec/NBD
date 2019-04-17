package com.footballstats.restapi.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@EnableConfigurationProperties(ClusterProperties.class)
public class CassandraConnector {
    public static final String SESSION = "session";

    private ClusterProperties properties;
    private Session session;
    private boolean initialized = false;

    public CassandraConnector(ClusterProperties properties) {
        this.properties = properties;
    }

    private void connect() {
        Cluster.Builder clusterBuilder = Cluster.builder()
                .withoutJMXReporting();

        for (String node : properties.getNodes()) {
            clusterBuilder.addContactPoint(node);
        }

        clusterBuilder.withPort(properties.getPort());
        Cluster cluster = clusterBuilder.build();
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
