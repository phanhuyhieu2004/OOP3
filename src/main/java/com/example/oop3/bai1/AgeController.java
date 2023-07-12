package com.example.oop3.bai1;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AgeController {
    @FXML
    TextField year;
//    Đây là khai báo một trường TextField được gắn với một trường trong tệp FXML. Trường này được sử dụng để nhập năm sinh của người dùng.

    @FXML
    protected void calculateAge() {
//        Đây là phương thức để tính toán tuổi dựa trên năm sinh được nhập vào từ trường year.
        int now = 2023;
        int age = now - Integer.parseInt(year.getText());
//        Đây là dòng code để tính toán tuổi, sử dụng năm hiện tại trừ đi năm sinh được nhập vào từ trường year. Hàm Integer.parseInt() được sử dụng để chuyển đổi giá trị nhập vào từ trường year thành một số nguyên.
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Tuổi của bạn là: " + age);
        alert.show();
    }
//    Hàm Integer.parseInt() được sử dụng để chuyển đổi một chuỗi ký tự thành một số nguyên. Nó có cú pháp như sau:
//    java
//
//    int parseInt(String s)
//
//    Trong đó:
//
//    Tham số s là chuỗi ký tự cần chuyển đổi thành số nguyên.
//    Trả về một số nguyên tương ứng với chuỗi ký tự được chuyển đổi.
//
//    Ví dụ, nếu bạn có một chuỗi ký tự "123", bạn có thể sử dụng hàm Integer.parseInt() để chuyển đổi nó thành một số nguyên như sau:
//    java
//
//    String s = "123";
//    int i = Integer.parseInt(s); // i sẽ có giá trị là 123
//
//    Trong trường hợp của mã nguồn trên, hàm Integer.parseInt() được sử dụng để chuyển đổi giá trị nhập vào từ trường year (là một chuỗi ký tự) thành một số nguyên để tính toán tuổi của người dùng.
}