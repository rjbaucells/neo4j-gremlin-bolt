package com.steelbridgelabs.oss.neo4j.structure.providers;

import com.steelbridgelabs.oss.neo4j.structure.Neo4JElementIdProvider;

import java.util.Objects;
import java.util.UUID;

/**
 * @author Rogelio J. Baucells
 */
public class Neo4JUuidProvider implements Neo4JElementIdProvider<String> {

    public static final String DefaultIdFieldName = "id";

    private final String idFieldName;

    public Neo4JUuidProvider() {
        this.idFieldName = DefaultIdFieldName;
    }

    public Neo4JUuidProvider(String fieldName) {
        Objects.requireNonNull(fieldName, "fieldName cannot be null");
        // store field name
        this.idFieldName = DefaultIdFieldName;
    }

    @Override
    public String idFieldName() {
        return idFieldName;
    }

    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
