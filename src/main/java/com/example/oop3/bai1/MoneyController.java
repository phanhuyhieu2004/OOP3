package com.example.oop3.bai1;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MoneyController {

    @FXML
    private TextField usdValue;
    @FXML
    private Label vndValue;

    private final double RATE = 23000.0;
//    hằng số biểu diễn tỷ giá giữa USD và VND.
//    Ở đây, tỷ giá được đặt là 23000 VND/USD.

//    Chúng được chú thích bằng @FXML để cho phép chúng được tải và quản lý bởi FXMLLoader.
//    TextField là thành phần giao diện người dùng để người dùng nhập vào giá trị USD cần chuyển đổi.
//    Label là thành phần giao diện người dùng để hiển thị giá trị VND tương ứng sau khi chuyển đổi.


    @FXML
    protected void convert() {
        double usd = Double.parseDouble(usdValue.getText());
        double vnd = usd * RATE;
        vndValue.setText("Giá trị VND tương ứng: " + vnd + " VND");
    }

//    Phương thức này được gọi khi người dùng click vào nút "Chuyển đổi".
//    Lấy giá trị của usdValue từ đối tượng TextField và chuyển đổi sang kiểu double thông qua phương thức parseDouble().
//    Tính giá trị tương ứng của VND bằng cách nhân usd với RATE.
//    Hiển thị giá trị tương ứng của VND trên đối tượng Label.
//
//    Chú ý rằng, trong phương thức convert(), chúng ta sử dụng phương thức setText() để hiển thị giá trị tương ứng của VND trên đối tượng Label. Ở đây, chúng ta nối chuỗi thông qua toán tử + để tạo chuỗi thông báo.


}