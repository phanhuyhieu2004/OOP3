import java.sql.*;
import java.util.Scanner;

public class StudentJDBC {
    private static final String URL_CONNECTION = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER_NAME = "root";
    private static final String PASS = "1";
    private static final Scanner scanner = new Scanner(System.in);

    public void connect() throws SQLException {

        Connection connection = DriverManager.getConnection(URL_CONNECTION, USER_NAME, PASS);
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addStudent(connection);
                    break;
                case 2:
                    printSV(connection);
                    break;
                case 3:
                    getSV(connection);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Không hợp lệ");
                    break;
            }
        }
    }

    public void printMenu() {
        System.out.println("Quản lý sinh viên :");
        System.out.println("1.Thêm dữ liệu");
        System.out.println("2.Hiển thị dữ liệu");
        System.out.println("3.Tìm tên của sinh viên");
        System.out.println("4.Nếu không muốn chọn thì làm ơn thoát đi");
        System.out.println("--------------------------------");
        System.out.println("Mời bạn nhập  :");
    }

    private void addStudent(Connection connection) {
        System.out.println("Nhập thông tin sv:");
        System.out.print("ID: ");
        int stuID = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Tên: ");
        String stuName = scanner.nextLine();
        System.out.print("Tuổi: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Giới tính: ");
        int gender = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Địa chỉ: ");
        String address = scanner.nextLine();

        String query = "INSERT INTO Student (stuID,stuName, age, gender, address) VALUES (?,?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,stuID);
            statement.setString(2, stuName);
            statement.setInt(3, age);
            statement.setInt(4, gender);
            statement.setString(5, address);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void printSV(Connection connection) throws SQLException {
        String query = "SELECT * FROM Student";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        System.out.println("Danh sách sv là :");
        while (resultSet.next()) {
            int id = resultSet.getInt("stuID");
            String name = resultSet.getString("stuName");
            int age = resultSet.getInt("age");
            int gender = resultSet.getInt("gender");
            String address = resultSet.getString("address");
            System.out.println("ID: " + id);
            System.out.println("Tên: " + name);
            System.out.println("Tuổi : " + age);
            System.out.println("Giới tính: " + gender);
            System.out.println("Địa chỉ: " + address);
            System.out.println("------------------------------");

        }

    }

    private void getSV(Connection connection) throws SQLException {
        System.out.print("Nhập tên sv: ");
        String name = scanner.nextLine();

        String query = "SELECT * FROM Student WHERE stuName LIKE ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Kết quả tìm kiếm:");
            while (resultSet.next()) {
                int id = resultSet.getInt("stuID");
                String userName = resultSet.getString("stuName");
                int age = resultSet.getInt("age");
                int gender = resultSet.getInt("gender");
                String address = resultSet.getString("address");
                System.out.println("ID: " + id);
                System.out.println("Tên: " + name);
                System.out.println("Tuổi : " + age);
                System.out.println("Giới tính: " + gender);
                System.out.println("Địa chỉ: " + address);
                System.out.println("------------------------------");
            }
        }
    }
}
