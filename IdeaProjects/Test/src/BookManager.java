import java.sql.*;
import java.util.Scanner;

public class BookManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/library";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1";
    private static final Scanner scanner = new Scanner(System.in);


    public void run() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            boolean exit = false;
            while (!exit) {
                printMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // Xóa ký tự xuống dòng từ bộ đệm đọc dữ liệu đầu vào

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
                        searchUserByName(connection);
                        break;
                    case 6:
                        exit = true;
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void printMenu() {
        System.out.println("========== Quản lý sách ==========");
        System.out.println("1. Thêm sách");
        System.out.println("2. Cập nhật sách");
        System.out.println("3. Xoá sách");
        System.out.println("4. Hiển thị hết ra");
        System.out.println("5. Tìm kiếm người dùng theo tên");
        System.out.println("6. Thoát");
        System.out.println("==================================");
        System.out.print("Nhập lựa chọn: ");
    }


    private void addBook(Connection connection) {
        System.out.println("Nhập thông tin sách:");
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Pages: ");
        int pages = scanner.nextInt();

        String query = "INSERT INTO book (title, author, year, pages) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setInt(3, year);
            statement.setInt(4, pages);
            statement.executeUpdate();
            System.out.println("Đã thêm sách thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateBook(Connection connection) throws SQLException {
        System.out.print("Nhập ID sách cần cập nhật:");
        int id = scanner.nextInt();
        scanner.nextLine();

        String query = "SELECT * FROM book WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Nhập thông tin sách:");
                System.out.print("Title: ");
                String title = scanner.nextLine();
                System.out.print("Author: ");
                String author = scanner.nextLine();
                System.out.print("Year: ");
                int year = scanner.nextInt();
                System.out.print("Pages: ");
                int pages = scanner.nextInt();

                String updateQuery = "UPDATE book SET title = ?, author = ?, year = ?, pages = ? WHERE id = ?";
                try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                    updateStatement.setString(1, title);
                    updateStatement.setString(2, author);
                    updateStatement.setInt(3, year);
                    updateStatement.setInt(4, pages);
                    updateStatement.setInt(5, id);
                    updateStatement.executeUpdate();
                    System.out.println("Sách được cập nhật thành công.");
                }
            } else {
                System.out.println("Không tìm thấy sách.");
            }
        }
    }

    private void deleteBook(Connection connection) throws SQLException {
        System.out.print("Nhập ID sách cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character from the input buffer

        String query = "SELECT * FROM book WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String deleteQuery = "DELETE FROM book WHERE id = ?";
                try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                    deleteStatement.setInt(1, id);
                    deleteStatement.executeUpdate();
                    System.out.println("Sách đã được xóa thành công.");
                }
            } else {
                System.out.println("Không tìm thấy sách.");
            }
        }
    }

    private void displayAllBooks(Connection connection) throws SQLException {
        String query = "SELECT * FROM book";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Danh sách:");
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
            }
        }
    }

    private void searchUserByName(Connection connection) throws SQLException {
        System.out.print("Nhập tên người dùng: ");
        String name = scanner.nextLine();

        String query = "SELECT * FROM user WHERE Author LIKE ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Kết quả tìm kiếm:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                System.out.println("ID: " + id);
                System.out.println("Name: " + userName);
                System.out.println("Age: " + age);
                System.out.println("Email: " + email);
                System.out.println("---------------------------");
            }
        }
    }
}