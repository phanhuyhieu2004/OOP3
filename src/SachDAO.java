import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SachDAO implements DAOInterface<Sach> {

    public static SachDAO getInstance() {
        return new SachDAO();
    }

    @Override
    public int insert(Sach t) throws SQLException {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL
            String sql = "INSERT INTO sach (id, tenSach, giaBan, namXuatBan) "+
                    " VALUES ('"+t.getId()+"' , '"+t.getTenSach()+"' , "+ t.getGiaBan()+" , '"+t.getNamXuatBan()+"')";

            ketQua = st.executeUpdate(sql);

            // Bước 4:
            System.out.println("Bạn đã thực thi: "+ sql);
            System.out.println("Có "+ ketQua+" dòng bị thay đổi!");

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }
    @Override
    public int update(Sach t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Sach t) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ArrayList<Sach> selectAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Sach selectById(Sach t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Sach> selectByCondition(String condition) {
        // TODO Auto-generated method stub
        return null;
    }

}
