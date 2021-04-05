package com.netcracker.utils.jdbc;

import java.sql.*;

public class JDBCPostgresql {

    Connection connection;

    public JDBCPostgresql() {

    }

    public Connection getNewConnection () throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found.");
            e.printStackTrace();
            return null;
        }
        String url = "jdbc:postgresql://localhost:5433/RepositoryDB";
        String user = "postgres";
        String pass = "root";
        this.connection = DriverManager.getConnection(url, user, pass);
        return connection;
    }

    public ResultSet getAllDataFromDB () throws SQLException {
        Statement statement = this.connection.createStatement();
        String query = "select * from people_contract";
        ResultSet rs = statement.executeQuery(query);
        return rs;
    }

    public void closeConnection () throws SQLException {
        connection.close();
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
