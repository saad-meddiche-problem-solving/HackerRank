package org.saadMeddiche.hackerrank_sql_problems;

import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;

import java.sql.*;
import java.util.Random;

@Slf4j
public class DataGenerator {

    private final static Faker faker = new Faker();
    private final static Random random = new Random();

    private final static String OCCUPATIONS_INSERT_QUERY =
            """
            INSERT INTO occupations (name, occupation) VALUES (?, ?)
            """;

    private final static String[] OCCUPATIONS = {"Doctor","Professor","Singer","Actor"};

    public static void main( String[] args ) throws SQLException {

        Connection connection = DriverManager.getConnection(HackerrankDatabaseConfig.URL, HackerrankDatabaseConfig.USER, HackerrankDatabaseConfig.PASSWORD);

        try(PreparedStatement preparedStatement = connection.prepareStatement(OCCUPATIONS_INSERT_QUERY)) {

            for(int i = 0; i < 100; i++) {
                preparedStatement.setString(1 , faker.name().firstName());
                preparedStatement.setString(2 , OCCUPATIONS[random.nextInt(OCCUPATIONS.length)]);
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
            log.info("OCCUPATIONS INSERTED IN DATABASE");

        } catch (Exception e) {
            log.error("Failed to generate data for table occupations.", e);
        }

    }

}
