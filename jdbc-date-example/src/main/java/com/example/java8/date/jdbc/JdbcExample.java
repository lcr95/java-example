package com.example.java8.date.jdbc;


import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;

@Slf4j
public class JdbcExample {

    public static final String POSTGRE_URL = "jdbc:postgresql://127.0.0.1:5433/postgres";

    public static void main(String[] args) {

        insertWithJavaTimeAPI();
        getResultSetWithJavaTimeAPI();

        insertWithJavaSqlAPI();
        getResultSetWithJavaSqlAPI();
    }

    private static void insertWithJavaTimeAPI() {
        try (Connection connection = DriverManager.getConnection(POSTGRE_URL, "postgres", "postgres")) {
            String insertSql = "INSERT INTO public.date_example (id, my_date, my_timestamp, my_time) VALUES(?,?,?,?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSql);

            insertStatement.setObject(1, "id1");
            insertStatement.setObject(2, LocalDate.now());
            insertStatement.setObject(3, OffsetDateTime.now());
            insertStatement.setObject(4, LocalTime.now());
            insertStatement.executeUpdate();

        } catch (Exception e) {
            log.error("error", e);
        }
    }

    private static void getResultSetWithJavaTimeAPI() {
        try (Connection connection = DriverManager.getConnection(POSTGRE_URL, "postgres", "postgres")) {
            String selectSql = "SELECT * FROM public.date_example WHERE id = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectSql);

            selectStatement.setObject(1, "id1");
            ResultSet resultSet = selectStatement.executeQuery();
            System.out.println("\nJava Time API");
            while (resultSet.next()) {
                LocalDate my_date = resultSet.getObject("my_date", LocalDate.class);
                System.out.println("my_date = " +  my_date.toString());

                OffsetDateTime my_timestamp = resultSet.getObject("my_timestamp", OffsetDateTime.class);
                System.out.println("my_timestamp =" + my_timestamp.toString());

                LocalTime my_time = resultSet.getObject("my_time", LocalTime.class);
                System.out.println("my_time =" + my_time.toString());
            }

        } catch (Exception e) {
            log.error("error", e);
        }
    }


    private static void insertWithJavaSqlAPI() {
        try (Connection connection = DriverManager.getConnection(POSTGRE_URL, "postgres", "postgres")) {
            String insertSql = "INSERT INTO public.date_example (id, my_date, my_timestamp, my_time) VALUES(?,?,?,?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSql);

            insertStatement.setObject(1, "id2");
            insertStatement.setObject(2, new Date(System.currentTimeMillis()));
            insertStatement.setObject(3, new Timestamp(System.currentTimeMillis()));
            insertStatement.setObject(4, new Time(System.currentTimeMillis()));
            insertStatement.executeUpdate();

        } catch (Exception e) {
            log.error("error", e);
        }
    }


    private static void getResultSetWithJavaSqlAPI() {
        try (Connection connection = DriverManager.getConnection(POSTGRE_URL, "postgres", "postgres")) {
            String selectSql = "SELECT * FROM public.date_example WHERE id = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectSql);

            selectStatement.setObject(1, "id2");
            ResultSet resultSet = selectStatement.executeQuery();
            System.out.println("\nJava Sql API");
            while (resultSet.next()) {
                Date my_date = resultSet.getDate("my_date");
                System.out.println("my_date = " +  my_date.toString());

                Timestamp my_timestamp = resultSet.getTimestamp("my_timestamp");
                System.out.println("my_timestamp =" + my_timestamp.toString());


                Time my_time = resultSet.getTime("my_time");
                System.out.println("my_time =" + my_time.toString());
            }

        } catch (Exception e) {
            log.error("error", e);
        }
    }

}
