package com.example.oop3.bai1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
//    Đây là khai báo một đối tượng Label (một nhãn trong giao diện người dùng) và sử dụng annotation @FXML để đánh dấu rằng đối tượng này được khai báo trong file FXML và sẽ được liên kết với đối tượng trong class controller này.
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
//    Đây là phương thức được gọi khi người dùng nhấn nút "Hello" trong giao diện người dùng. Chúng ta sử dụng annotation @FXML để đánh dấu rằng phương thức này được gọi từ file FXML và sẽ được kết nối với sự kiện nhấn nút trong giao diện người dùng. Khi phương thức được gọi, nó sẽ thay đổi nội dung của đối tượng Label "welcomeText" thành chuỗi "Welcome to JavaFX Application!".
}