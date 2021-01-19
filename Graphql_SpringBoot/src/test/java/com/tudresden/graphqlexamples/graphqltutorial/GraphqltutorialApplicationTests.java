package com.tudresden.graphqlexamples.graphqltutorial;

import graphql.ExecutionResult;
import graphql.GraphQL;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class GraphqltutorialApplicationTests {

/*
	@Test
	void contextLoads() {
		System.out.println("Hello World");
		graphQlHelloWorld();
	}
*/

	public static void graphQlHelloWorld() {
		String schema = "type Query{hello: String} ";
		try {
			SchemaParser schemaParser = new SchemaParser();
			TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);

			RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
					.type("Query", builder -> builder.dataFetcher("hello fetcher", new StaticDataFetcher("world")))
					.build();

			SchemaGenerator schemaGenerator = new SchemaGenerator();
			GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);

			GraphQL build = GraphQL.newGraphQL(graphQLSchema).build();
			ExecutionResult executionResult = build.execute("hello fetcher");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
