# neo4j-gremlin-bolt

[![Build Status](https://travis-ci.org/SteelBridgeLabs/neo4j-gremlin-bolt.svg?branch=master)](https://travis-ci.org/SteelBridgeLabs/neo4j-gremlin-bolt)

This project allows the use of the [Apache Tinkerpop](http://tinkerpop.apache.org/) Java API with the [neo4j server](http://neo4j.com/) using the [BOLT](https://github.com/neo4j/neo4j-java-driver) protocol.

## Usage

Add the Neo4j [Apache Tinkerpop](http://tinkerpop.apache.org/) implementation to your project:

### Maven

```xml
    <dependency>
        <groupId>com.steelbridgelabs.oss</groupId>
        <artifactId>neo4j-gremlin-bolt</artifactId>
        <version>{version}</version>
    </dependency>
```

### Gradle

```xml
    dependencies {
        compile 'com.steelbridgelabs.oss:neo4j-gremlin-bolt:{version}'
    }
```

### Ivy

```xml
    <dependency org="com.steelbridgelabs.oss" name="neo4j-gremlin-bolt" rev="{version}" />
```

*Please check the [Releases](https://github.com/SteelBridgeLabs/neo4j-gremlin-bolt/releases) for the latest version available.

## License

neo4j-gremlin-bolt and it's modules are licensed under the [Apache License v 2.0](http://www.apache.org/licenses/LICENSE-2.0).

# Graph API

## Connecting to the database

- Create driver instance, see [neo4j-java-driver](https://github.com/neo4j/neo4j-java-driver) for more information.

```java
    // create driver instance
    Driver driver = GraphDatabase.driver("bolt://localhost", AuthTokens.basic("neo4j", "neo4j"));
```

- Create id provider instances, see providers for more information. 

```java
    // create id provider instances
    vertexIdProvider = ...
    edgeIdProvider = ...
    propertyIdProvider = ...
```

- Create [Graph](http://tinkerpop.apache.org/javadocs/current/core/org/apache/tinkerpop/gremlin/structure/Graph.html) instance.

```java
    // create graph instance
    try (Graph graph = new Neo4JGraph(driver, vertexIdProvider, edgeIdProvider, propertyIdProvider)) {
        
    }
```

## Working with transactions

- Obtain a [Transaction](http://tinkerpop.apache.org/javadocs/current/core/org/apache/tinkerpop/gremlin/structure/Transaction.html) instance from current Graph.

```java
    // create graph instance
    try (Graph graph = new Neo4JGraph(driver, vertexIdProvider, edgeIdProvider, propertyIdProvider)) {
        // begin transaction
        try (Transaction transaction = graph.tx()) {
            // use Graph API to create, update and delete Vertices and Edges
            
            // commit transaction
            transaction.commit();
        }
    }
```

## Working with Vertices and Edges

### Create a Vertex

Create a new [Vertex](http://tinkerpop.apache.org/javadocs/current/core/org/apache/tinkerpop/gremlin/structure/Vertex.html) in the current `graph` call the [Graph.addVertex()](http://tinkerpop.apache.org/javadocs/current/core/org/apache/tinkerpop/gremlin/structure/Graph.html#addVertex-java.lang.Object...-) method.

```java
  // create a vertex in current graph
  Vertex vertex = graph.addVertex();
```

Create a new [Vertex](http://tinkerpop.apache.org/javadocs/current/core/org/apache/tinkerpop/gremlin/structure/Vertex.html) in the current `graph` with property values: 

```java
  // create a vertex in current graph with property values
  Vertex vertex = graph.addVertex("name", "John", "age", 50);
```

Create a new [Vertex](http://tinkerpop.apache.org/javadocs/current/core/org/apache/tinkerpop/gremlin/structure/Vertex.html) in the current `graph` with a Label: 

```java
  // create a vertex in current graph with label
  Vertex vertex1 = graph.addVertex("Person");
  // create another vertex in current graph with label
  Vertex vertex2 = graph.addVertex(T.label, "Company");
```
