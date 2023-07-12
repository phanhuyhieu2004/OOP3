package com.example.oop3.bai1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    TextField username;
    @FXML
    PasswordField password;

//    Đây là hai thuộc tính TextField và PasswordField được đánh dấu bằng @FXML, có nghĩa là chúng sẽ được tải và quản lý bởi FXMLLoader.
//    TextField và PasswordField là các thành phần giao diện người dùng để người dùng nhập vào thông tin tài khoản và mật khẩu.

    @FXML
    protected void login() {
        String username = this.username.getText();
        String password = this.password.getText();

        if (username.equals("admin") && password.equals("password")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Đăng nhập thành công");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Đăng nhập thất bại");
            alert.show();
        }
    }

//    Đây là phương thức login() được đánh dấu bằng @FXML, có nghĩa là nó sẽ được gọi khi người dùng click vào nút "Đăng nhập".
//    Trong phương thức này, đầu tiên chúng ta lấy giá trị của username và password từ hai thuộc tính TextField và PasswordField thông qua phương thức getText().
//    Sau đó, chúng ta kiểm tra xem username và password có khớp với giá trị "admin" và "password" hay không. Nếu đúng, chúng ta tạo một đối tượng Alert với loại thông báo AlertType.INFORMATION, và hiển thị thông báo "Đăng nhập thành công". Nếu không đúng, chúng ta tạo một đối tượng Alert với loại thông báo AlertType.INFORMATION, và hiển thị thông báo "Đăng nhập thất bại".
//    Cuối cùng, chúng ta gọi phương thức show() trên đối tượng Alert để hiển thị hộp thoại thông báo cho người dùng.

}