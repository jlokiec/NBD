package com.footballstats.restapi.cassandra;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

public class PreparedStatementCache {
    private Map<String, PreparedStatement> preparedStatements;

    @Resource(name = CassandraConfiguration.SESSION)
    private Session session;

    public PreparedStatementCache() {
        preparedStatements = new HashMap<>();
    }

    public BoundStatement getCqlStatement(String cqlQuery) {
        PreparedStatement preparedStatement = preparedStatements.get(cqlQuery);

        if (preparedStatement == null) {
            preparedStatement = session.prepare(cqlQuery);
            preparedStatements.put(cqlQuery, preparedStatement);
        }

        return preparedStatement.bind();
    }
}
