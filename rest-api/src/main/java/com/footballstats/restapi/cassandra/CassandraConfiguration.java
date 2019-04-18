package com.footballstats.restapi.cassandra;

import com.datastax.driver.core.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CassandraConfiguration {
    public static final String SESSION = "session";
    public static final String STATEMENT_CACHE = "statementCache";

    private CassandraConnector cassandraConnector;

    @Autowired
    public CassandraConfiguration(CassandraConnector cassandraConnector) {
        this.cassandraConnector = cassandraConnector;
    }

    @Bean(name = SESSION)
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Session getSession() {
        cassandraConnector.connect();
        Session session = cassandraConnector.getSession();
        session.execute("use european_league_results;");
        return session;
    }

    @Bean(name = STATEMENT_CACHE)
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public PreparedStatementCache getStatementCache() {
        return new PreparedStatementCache();
    }
}
