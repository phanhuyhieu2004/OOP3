import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws SQLException {

//        ConnectProduct connectProduct=new ConnectProduct();
//        connectProduct.connect();
//        ConnectProduct.insertConnection();
//        ConnectProduct.update1Connection();
//        ConnectProduct.update2Connection();
//        ConnectProduct.deleteConnection();
//        ConnectProduct.getAll();
//        ConnectProduct.getProductsById(1);
//        ConnectProduct.getProductsById(2);
//        ConnectProduct.getProductsByStatus(1);
        ConnectProduct.getProductsByStatusAndNumber(1,9);
    }
}
