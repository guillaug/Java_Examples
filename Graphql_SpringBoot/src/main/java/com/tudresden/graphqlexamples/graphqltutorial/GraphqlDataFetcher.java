package com.tudresden.graphqlexamples.graphqltutorial;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;
import graphql.schema.DataFetcher;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


@Component
public class GraphqlDataFetcher {
    private static final Logger logger = Logger.getLogger(GraphQLProvider.class.getName());

    private static List<Map<String, String>> books = Arrays.asList(
            ImmutableMap.of("id", "book-1",
                    "name", "Prisoner Dilemma",
                    "pageCount", "223",
                    "authorId", "author-1"),
            ImmutableMap.of("id", "book-2",
                    "name", "Moby Dick",
                    "pageCount", "1123",
                    "authorId", "author-2"),
            ImmutableMap.of("id", "book-3",
                            "name", "to the path of the heaven",
                            "pageCount", "1000",
                            "authorId", "author-3")
    );

    private static List<Map<String, String>> authors = Arrays.asList(
            ImmutableMap.of("id", "author-1",
                    "firstName", "Joanne",
                    "lastName", "Rowling"),
            ImmutableMap.of("id", "author-2",
                    "firstName", "Herman",
                    "lastName", "Melville"),
            ImmutableMap.of("id", "author-3",
                            "firstName", "Anne",
                            "lastName", "Rice")
    );

    public DataFetcher getBookByIdDataFetcher() {
        logger.info("DataFetcher getBookByIdDataFetcher");
        return datafetchEnv -> {
            String bookId = datafetchEnv.getArgument("id");
            return books
                    .stream()
                    .filter(book -> book.get("id").equals(bookId))
                    .findFirst()
                    .orElse(null);
        };
    }

    //Testing with Graphql is necessary in Postman
    public DataFetcher getAuthorDataFetcher() {
        logger.info("DataFetcher getAuthorDataFetcher");
        return datafetchEnv -> {
            Map<String, String> book = datafetchEnv.getSource();
            String authorId = book.get("authorId");
            return authors
                    .stream()
                    .filter(author -> author.get("id").equals(authorId))
                    .findFirst()
                    .orElse(null);
        };
    }

}
