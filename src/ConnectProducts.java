import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class ConnectProducts {
    //    Các thông số
    private String hostName = "localhost:3306";
    private String dbName = "demo_jdbc";
    private String username = "root";
    private String password = "1";
    //    URL liên kết DB với JDBC

    private String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;
    public Connection connect() throws SQLException {
        //Tạo đối tượng Connection
        Connection conn = null;

        try {
            conn = getConnection(connectionURL, username, password);
            System.out.println("Kết nối thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
    public static void insertConnect() throws SQLException {

        Connection con = JDBCUtil.getConnection();

        Statement st = con.createStatement();
        for (int i = 1; i <= 10; i++) {
            String name = "Product " + i;
            double price = Math.random() * 100; // Giá ngẫu nhiên từ 0 đến 100
            String detail = "Product detail " + i;
            String manufacturer = "Manufacturer " + i;
            int number = (int) (Math.random() * 100); // Số lượng ngẫu nhiên từ 0 đến 100
            String status = (number > 0) ? "Còn hàng" : "Hết hàng";

            String sql = "INSERT INTO products (name, price, detail, manufacturer, number, status) " +
                    "VALUES ('" + name + "', " + price + ", '" + detail + "', '" + manufacturer + "', " + number + ", '" + status + "')";

            st.executeUpdate(sql);
        }

        System.out.println("Thêm bản ghi thành công!");
        JDBCUtil.closeConnection(con);
    }
}
