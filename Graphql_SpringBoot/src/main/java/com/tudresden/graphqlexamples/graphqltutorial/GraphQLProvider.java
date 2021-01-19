package com.tudresden.graphqlexamples.graphqltutorial;


import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

@Component
public class GraphQLProvider {

    private static final Logger logger = Logger.getLogger(GraphQLProvider.class.getName());

    @Autowired
    GraphqlDataFetcher graphqlDataFetcher;


    private GraphQL graphQL;

    @PostConstruct
    public void init() throws IOException {
        logger.info("init function");
        URL url = Resources.getResource("schema.graphqls");
        String urlSchema = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(urlSchema);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    //Schema Definition Language (SDL).
    private GraphQLSchema buildSchema(String buildSchemaDefinitionLanguage)
    {
        logger.info("buildSchema function");
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(buildSchemaDefinitionLanguage);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        logger.info("buildWiring function");
        return RuntimeWiring.newRuntimeWiring()
                .type(TypeRuntimeWiring.newTypeWiring("Query")
                        .dataFetcher("bookById", graphqlDataFetcher.getBookByIdDataFetcher()))
                .type(TypeRuntimeWiring.newTypeWiring("Book")
                        .dataFetcher("author", graphqlDataFetcher.getAuthorDataFetcher()))
                .build();
    }

    @Bean
    public GraphQL graphQL() {
        logger.info("graphQL Bean");
        return graphQL;
    }

}
