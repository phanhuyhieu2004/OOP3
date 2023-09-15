package com.example.oop3.bai1;

import java.sql.*;
import java.util.Scanner;

public class BookManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/library";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        bookManager.run();
    }

    public void run() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            createTableIfNotExists(connection);

            boolean exit = false;
            while (!exit) {
                printMenu();
                int choice = getUserChoice();

                switch (choice) {
                    case 1:
                        addBook(connection);
                        break;
                    case 2:
                        updateBook(connection);
                        break;
                    case 3:
                        deleteBook(connection);
                        break;
                    case 4:
                        displayAllBooks(connection);
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableIfNotExists(Connection connection) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS books (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "title VARCHAR(100) NOT NULL," +
                "author VARCHAR(100) NOT NULL," +
                "year INT NOT NULL," +
                "pages INT NOT NULL" +
                ")";
        Statement statement = connection.createStatement();
        statement.execute(query);
    }

    private void printMenu() {
        System.out.println("----- Book Manager -----");
        System.out.println("1. Add Book");
        System.out.println("2. Update Book");
        System.out.println("3. Delete Book");
        System.out.println("4. Display All Books");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return choice;
    }

    private void addBook(Connection connection) throws SQLException {
        System.out.println("----- Add Book -----");
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        System.out.print("Enter number of pages: ");
        int pages = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String query = "INSERT INTO books (title, author, year, pages) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, author);
        preparedStatement.setInt(3, year);
        preparedStatement.setInt(4, pages);
        preparedStatement.executeUpdate();

        System.out.println("Book added successfully.");
    }

    private void updateBook(Connection connection) throws SQLException {
        System.out.println("----- Update Book -----");
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String query = "SELECT * FROM books WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, bookId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.print("Enter new title (current title: " + resultSet.getString("title") + "): ");
            String title = scanner.nextLine();
            System.out.print("Enter new author (current author: " + resultSet.getString("author") + "): ");
            String author = scanner.nextLine();
            System.out.print("Enter new year (current year: " + resultSet.getInt("year") + "): ");
            int year = scanner.nextInt();
            System.out.print("Enter new number of pages (current pages: " + resultSet.getInt("pages") + "): ");
            int pages = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            String updateQuery = "UPDATE books SET title = ?, author = ?, year = ?, pages = ? WHERE id = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setString(1, title);
            updateStatement.setString(2, author);
            updateStatement.setInt(3, year);
            updateStatement.setInt(4, pages);
            updateStatement.setInt(5, bookId);
            updateStatement.executeUpdate();

            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private void deleteBook(Connection connection) throws SQLException {
        System.out.println("----- Delete Book -----");
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String query = "SELECT * FROM books WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, bookId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String deleteQuery = "DELETE FROM books WHERE id = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.setInt(1, bookId);
            deleteStatement.executeUpdate();

            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private void displayAllBooks(Connection connection) throws SQLException {
        System.out.println("----- All Books -----");
        String query = "SELECT * FROM books";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            int year = resultSet.getInt("year");
            int pages = resultSet.getInt("pages");

            System.out.println("ID: " + id);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Year: " + year);
            System.out.println("Pages: " + pages);
            System.out.println("--------------------");
        }
    }
}