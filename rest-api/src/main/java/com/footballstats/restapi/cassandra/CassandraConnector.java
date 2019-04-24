package com.footballstats.restapi.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ClusterProperties.class)
public class CassandraConnector {
    private ClusterProperties properties;
    private Session session;

    public CassandraConnector(ClusterProperties properties) {
        this.properties = properties;
    }

    public void connect() {
        Cluster.Builder clusterBuilder = Cluster.builder()
                .withoutJMXReporting();

        for (String node : properties.getNodes()) {
            clusterBuilder.addContactPoint(node);
        }

        clusterBuilder.withPort(properties.getPort());
        Cluster cluster = clusterBuilder.build();
        session = cluster.connect();
    }

    public Session getSession() {
        connect();
        return session;
    }
}
