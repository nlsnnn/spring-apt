package com.start.egor.dbexample.db;

import java.sql.*;

import static com.start.egor.dbexample.constants.DBConstants.*;

public enum DBConnection {
    INSTANCE;
    private Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:postgresql://" + DB_HOST + ":" + PORT + "/" + DB, USER, PASSWORD);
        }
        return connection;
    }
}
