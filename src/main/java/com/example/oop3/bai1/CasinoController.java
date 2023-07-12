package com.example.oop3.bai1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CasinoController {

    @FXML
    private TextField num1TextField;

    @FXML
    private TextField num2TextField;

    @FXML
    private Button addButton;

    @FXML
    private Button subtractButton;

    @FXML
    private Button multiplyButton;

    @FXML
    private Button divideButton;
//    có 2 TextField để nhập các số và 4 Button để thực hiện các phép tính. Các thành phần này được đặt tên và liên kết với các biến tương ứng trong lớp CasinoController.

    @FXML
    private void add() {
        double num1 = getNum1();
        double num2 = getNum2();
        double result = num1 + num2;
        displayResult(result);

//        Phương thức này được gọi khi người dùng nhấn nút "Cộng".
//                Lấy giá trị của hai số nhập vào từ num1TextField và num2TextField.
//                Thực hiện phép cộng và lưu kết quả vào biến result.
//        Hiển thị kết quả bằng cách gọi phương thức displayResult().

    }

    @FXML
    private void subtract() {
        double num1 = getNum1();
        double num2 = getNum2();
        double result = num1 - num2;
        displayResult(result);

//        Phương thức này được gọi khi người dùng nhấn nút "Trừ".
//                Lấy giá trị của hai số nhập vào từ num1TextField và num2TextField.
//                Thực hiện phép trừ và lưu kết quả vào biến result.
//        Hiển thị kết quả bằng cách gọi phương thức displayResult().

    }

    @FXML
    private void multiply() {
        double num1 = getNum1();
        double num2 = getNum2();
        double result = num1 * num2;
        displayResult(result);

//        Phương thức này được gọi khi người dùng nhấn nút "Nhân".
//                Lấy giá trị của hai số nhập vào từ num1TextField và num2TextField.
//                Thực hiện phép nhân và lưu kết quả vào biến result.
//        Hiển thị kết quả bằng cách gọi phương thức displayResult().

    }

    @FXML
    private void divide() {
        double num1 = getNum1();
        double num2 = getNum2();
        if (num2 == 0) {
            displayError("Không thể chia cho số không");
            return;
        }
        double result = num1 / num2;
        displayResult(result);

//        Phương thức này được gọi khi người dùng nhấn nút "Chia".
//                Lấy giá trị của hai số nhập vào từ num1TextField và num2TextField.
//                Kiểm tra xem số thứ hai có bằng 0 hay không. Nếu có, hiển thị thông báo lỗi bằng cách gọi phương thức displayError() và thoát khỏi phương thức.
//                Thực hiện phép chia và lưu kết quả vào biến result.
//        Hiển thị kết quả bằng cách gọi phương thức displayResult().

    }

    private double getNum1() {
        try {
            return Double.parseDouble(num1TextField.getText());
        } catch (NumberFormatException e) {
            displayError("Số thứ nhất được nhập vào không hợp lệ");
            throw e;
        }

//        Phương thức này trả về giá trị của số thứ nhất đã được nhập vào từ num1TextField.
//                Nếu giá trị nhập vào không phải là một số hợp lệ, hiển thị thông báo lỗi bằng cách gọi phương thức displayError().

    }

    private double getNum2() {
        try {
            return Double.parseDouble(num2TextField.getText());
        } catch (NumberFormatException e) {
            displayError("Số thứ 2 được nhập vào không hợp lệ");
            throw e;
        }

//        Phương thức này trả về giá trị của số thứ hai đã được nhập vào từ num2TextField.
//                Nếu giá trị nhập vào không phải là một số hợp lệ, hiển thị thông báo lỗi bằng cách gọi phương thức displayError().

    }

    private void displayResult(double result) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Kết quả :");
        alert.setHeaderText(null);
        alert.setContentText("Kết quả là :" + result);
        alert.showAndWait();

//        Phương thức này hiển thị kết quả của phép tính bằng cách tạo một hộp thoại Alert và thiết lập các thông tin cần thiết, bao gồm tiêu đề, thông báo và kiểu hộp thoại.
//                Hộp thoại được hiển thị bằng phương thức showAndWait().

    }

    private void displayError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Lỗi");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

//        Phương thức này hiển thị một thông báo lỗi bằng cách tạo một hộp thoại Alert và thiết lập các thông tin cần thiết, bao gồm tiêu đề, thông báo và kiểu hộp thoại.
//                Hộp thoại được hiển thị bằng phương thức showAndWait().

    }

}