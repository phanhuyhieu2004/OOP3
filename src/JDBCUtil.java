import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection() throws SQLException {
//        Kết nối với DB
Connection c=null;
//đăng ký MySQL driver với lớp driver manager
//        com.mysql.cj.jdbc.Driver driver=new Driver();
//        DriverManager.registerDriver( new com.mysql.jdbc.Driver());
//        Các thông số
String url="jdbc:mySQL://localhost:3306/book";
String username="root";
String password="1";
//Tạo kết nối
        c=DriverManager.getConnection(url,username,password);



return c;

    }
    public static void closeConnection(Connection c) throws SQLException {
        if(c!=null){
            c.close();
        }

    }
    public static void printInfo(Connection c) throws SQLException {
        if(c!=null){
//            Lấy thông tin của DB thông qua lớp DatabaseMetaData
            DatabaseMetaData mtdt=c.getMetaData();
            System.out.print(mtdt.getDatabaseProductName());
            System.out.print(mtdt.getDatabaseProductVersion());
        }
    }
}
