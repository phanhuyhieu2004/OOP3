package com.example.oop3.cs;

import java.sql.*;

public class ImportToDatabase {
    private static String hostName = "localhost:3306";
    private static String dbName = "chat_db";
    private static String username = "root";
    private static String password = "1";
    private static String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;


    public static Connection connectToDatabase() throws SQLException {
        Connection connection = DriverManager.getConnection(connectionURL, username, password);
        return connection;
    }

    public void addToDatabase(String name, String message) throws SQLException {
        Connection connection = ImportToDatabase.connectToDatabase();
        String query = "INSERT INTO DataMessage (name, messages) VALUES ('" + name + "', '" + message + "')";        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void deleteAll() throws SQLException {
        Connection connection = ImportToDatabase.connectToDatabase();
        String query = "DELETE FROM DataMessage";

        Statement statement = connection.createStatement();
        statement.executeUpdate(query);

    }

    public StringBuilder readMessages() throws SQLException {
        Connection connection = ImportToDatabase.connectToDatabase();

        String query = "SELECT name, messages FROM DataMessage";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
//             Tạo 1 đtg chứa các tin đã đọc
        StringBuilder messages = new StringBuilder();
//            Con trỏ của result đi qua các hàng cho đến khi kết thúc
        while (resultSet.next()) {
//                trích xuất dữ liệu từ 2 cột
            String name = resultSet.getString("name");
            String message = resultSet.getString("messages");
            messages.append(name).append(message).append("\n");
//                nối lại và hiển thị thôi
        }
        return messages;
    }
}

