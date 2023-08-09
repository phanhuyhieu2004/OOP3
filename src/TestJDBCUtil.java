import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCUtil {
    public static void main(String[] args) throws SQLException {
//        B1:Tạo kết nối
        Connection connection=JDBCUtil.getConnection();
        System.out.println(connection);
//Tạo ra đối tượng statement
        Statement st=connection.createStatement();
//        B3:thực thi lệnh sql
        String sql="INSERT INTO Persons(last_name,first_name,gender,dob,income)" +  "VALUES(\"Tran\",\"My\",\"C\",\"1996-05-10\",\"10000\")";
        int check=st.executeUpdate(sql);
//        B4:Xử lý kết quả
        System.out.println("Số dòng thay đổi: "+check);
        if (check>0){
            System.out.println("Thêm dữ liệu thành công");
        }
        else{
            System.out.println("Thất bại ");
        }


//        B5:ngắt kết nối
        JDBCUtil.closeConnection(connection);
        System.out.println(connection);
//        JDBCUtil.printInfo(connection);
    }
}
