import java.sql.SQLException;

public class TestSachDao {
    public static void main(String[] args) throws SQLException {

        Sach sach1 = new Sach("LTJV", "Lập trình Java", 50000, 2025);
        Sach sach2 = new Sach("LTC", "Lập trình C", 70000, 2030);
        SachDAO.getInstance().insert(sach2);
    }
}
