import java.sql.*;

public class ConnectProduct {
    private String hostName = "localhost:3306";
    private String dbName = "product_manager_database";
    private String username = "root";
    private String password = "1";

    private String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;

    public Connection connect() throws SQLException {
        //Tạo đối tượng Connection
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(connectionURL, username, password);
            System.out.println("Kết nối thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
    public static void insertConnection() throws SQLException {
        ConnectProduct connectProducts = new ConnectProduct();
        Connection conn = connectProducts.connect();

        String query = "INSERT INTO products (id, name, price, detail, manufacturer, number, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);

            for (int i = 1; i <= 10; i++) {
                int id = i; // Giá trị id tương ứng với bản ghi

                String name = "Sản phẩm " + i;
                double price = Math.random() * 100; // Giá ngẫu nhiên từ 0 đến 100
                String detail = "Chi tiết sản phẩm " + i;
                String manufacturer = "NSX " + i;
                int number = (int) (Math.random() * 100); // Số lượng ngẫu nhiên từ 0 đến 100
                int status = (number > 0) ? 1 : 0;
                pstm.setInt(1, id);
                pstm.setString(2, name);
                pstm.setDouble(3, price);
                pstm.setString(4, detail);
                pstm.setString(5, manufacturer);
                pstm.setInt(6, number);
                pstm.setInt(7, status);

                pstm.executeUpdate();
            }

            System.out.println("Thêm bản ghi thành công!");

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void update1Connection() throws SQLException {
        ConnectProduct connectProducts = new ConnectProduct();
        Connection conn = connectProducts.connect();

        String query = "UPDATE products SET detail = ? WHERE id = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);

            pstm.setString(1, "dữ liệu mới");
            pstm.setInt(2, 4);

            int row = pstm.executeUpdate();
            if(row != 0){
                System.out.println("Cập nhật thành công " + row);
            }

            // Đóng kết nối
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void update2Connection() throws SQLException {
        ConnectProduct connectProducts = new ConnectProduct();
        Connection conn = connectProducts.connect();

        String query = "UPDATE products SET manufacturer = ?, price = ? WHERE id = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);

            pstm.setString(1, "apple");
            pstm.setString(2, "12000000");
            pstm.setInt(3, 2);

            int row = pstm.executeUpdate();
            if(row != 0){
                System.out.println("Cập nhật thành công " + row);
            }

            // Đóng kết nối
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void update3Connection() throws SQLException {
        ConnectProduct connectProducts = new ConnectProduct();
        Connection conn = connectProducts.connect();

        String query = "UPDATE products SET number = ?, status = ? WHERE id = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);

            pstm.setInt(1, 20);
            pstm.setInt(2, 0);
            pstm.setInt(3, 6);


            int row = pstm.executeUpdate();
            if(row != 0){
                System.out.println("Cập nhật thành công " + row);
            }

            // Đóng kết nối
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteConnection() throws SQLException {
        ConnectProduct connectProducts = new ConnectProduct();
        Connection conn = connectProducts.connect();

        String query = "DELETE FROM products WHERE id = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);

            pstm.setInt(1, 4);  // Xóa bản ghi có ID là 4

            int row = pstm.executeUpdate();
            if(row != 0){
                System.out.println("Xóa thành công " + row);
            }

            // Đóng kết nối
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  static void getAll() throws SQLException {
        ConnectProduct connectProducts = new ConnectProduct();
        Connection conn = connectProducts.connect();

        String query = "SELECT * FROM products";

        Statement stm = null;
        try {
            stm = conn.createStatement();

            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String detail = rs.getString("detail");
                String manufacturer = rs.getString("manufacturer");
                int number = rs.getInt("number");
                int status = rs.getInt("status");

                System.out.println("ID: " + id);
                System.out.println("Tên: " + name);
                System.out.println("Giá: " + price);
                System.out.println("Chi tiết: " + detail);
                System.out.println("NSX: " + manufacturer);
                System.out.println("Số lượng : " + number);
                System.out.println("Tình trạng: " + status);
                System.out.println("==========================");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  static void  getProductsById(int id1) throws SQLException {
        ConnectProduct connectProducts = new ConnectProduct();
        Connection conn = connectProducts.connect();

        String query = "SELECT * FROM products WHERE id = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, id1);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String detail = rs.getString("detail");
                String manufacturer = rs.getString("manufacturer");
                int number = rs.getInt("number");
                int status = rs.getInt("status");

                System.out.println("ID: " + id);
                System.out.println("Tên: " + name);
                System.out.println("Giá: " + price);
                System.out.println("Chi tiết: " + detail);
                System.out.println("NSX: " + manufacturer);
                System.out.println("Số lượng : " + number);
                System.out.println("Tình trạng: " + status);
                System.out.println("==========================");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getProductsByIds(int id1, int id2) throws SQLException {
        ConnectProduct connectProducts = new ConnectProduct();
        Connection conn = connectProducts.connect();

        String query = "SELECT * FROM products WHERE id = ? OR id = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, 3);
            pstm.setInt(2, 5);

            ResultSet rs = pstm.executeQuery();

            while (rs.next())  {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String detail = rs.getString("detail");
                String manufacturer = rs.getString("manufacturer");
                int number = rs.getInt("number");
                int status = rs.getInt("status");

                System.out.println("ID: " + id);
                System.out.println("Tên: " + name);
                System.out.println("Giá: " + price);
                System.out.println("Chi tiết: " + detail);
                System.out.println("NSX: " + manufacturer);
                System.out.println("Số lượng : " + number);
                System.out.println("Tình trạng: " + status);
                System.out.println("==========================");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void getProductsByStatus(int status1) throws SQLException {
        ConnectProduct connectProducts = new ConnectProduct();
        Connection conn = connectProducts.connect();

        String query = "SELECT * FROM products WHERE status = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, status1);

            ResultSet rs = pstm.executeQuery();

            while (rs.next())   {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String detail = rs.getString("detail");
                String manufacturer = rs.getString("manufacturer");
                int number = rs.getInt("number");
                int status = rs.getInt("status");

                System.out.println("ID: " + id);
                System.out.println("Tên: " + name);
                System.out.println("Giá: " + price);
                System.out.println("Chi tiết: " + detail);
                System.out.println("NSX: " + manufacturer);
                System.out.println("Số lượng : " + number);
                System.out.println("Tình trạng: " + status);
                System.out.println("==========================");
            }


            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  static void getProductsByStatusAndNumber(int status1, int number1) throws SQLException {
        ConnectProduct connectProducts = new ConnectProduct();
        Connection conn = connectProducts.connect();

        String query = "SELECT * FROM products WHERE status = ? AND number = ?";

        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, status1);
            pstm.setInt(2, number1);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String detail = rs.getString("detail");
                String manufacturer = rs.getString("manufacturer");
                int number = rs.getInt("number");
                int status = rs.getInt("status");

                System.out.println("ID: " + id);
                System.out.println("Tên: " + name);
                System.out.println("Giá: " + price);
                System.out.println("Chi tiết: " + detail);
                System.out.println("NSX: " + manufacturer);
                System.out.println("Số lượng : " + number);
                System.out.println("Tình trạng: " + status);
                System.out.println("==========================");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



