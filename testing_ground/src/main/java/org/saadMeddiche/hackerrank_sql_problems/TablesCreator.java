package org.saadMeddiche.hackerrank_sql_problems;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class TablesCreator {

    private final static String OCCUPATIONS_TABLE_CREATE_QUERY =
            """
            CREATE TABLE occupations (
                name varchar(255),
                occupation varchar(255)
            )
            """;

    public static void main( String[] args ) throws SQLException {

        Connection connection = DriverManager.getConnection(HackerrankDatabaseConfig.URL, HackerrankDatabaseConfig.USER, HackerrankDatabaseConfig.PASSWORD);

        try(Statement statement = connection.createStatement()) {
            statement.execute(OCCUPATIONS_TABLE_CREATE_QUERY);
            log.info("Successfully added occupations table");
        } catch (Exception e) {
            log.error("Failed to create occupations table",e);
        }

    }

}
