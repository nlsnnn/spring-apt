package com.start.egor.dbexample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.*;

import static com.start.egor.dbexample.constants.DBConstants.*;

@Configuration
public class MyDBConfigContext {
    @Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://" + DB_HOST + ":" + PORT + "/" + DB, USER, PASSWORD);
    }
}
