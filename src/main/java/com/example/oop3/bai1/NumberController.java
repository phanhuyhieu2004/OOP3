package com.example.oop3.bai1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Random;

public class NumberController {

    private int numberToGuess;
//    Thuộc tính numberToGuess.
//
//    Đây là số nguyên mà người dùng cần đoán.
//    Số này được tạo ngẫu nhiên trong phương thức reset() và được giữ nguyên trong suốt quá trình chơi.


    @FXML
    private TextField guessTextField;

    @FXML
    private Button guessButton;
//    Định nghĩa hai đối tượng TextField và Button.
//
//    Chúng được chú thích bằng @FXML để cho phép chúng được tải và quản lý bởi FXMLLoader.
//    TextField là thành phần giao diện người dùng để nhập số đoán vào.
//    Button là thành phần giao diện người dùng để xác nhận số đoán.


    @FXML
    private void guess() {
        try {
            int guess = Integer.parseInt(guessTextField.getText());
            if (guess == numberToGuess) {
                displayResult("Chính xác! Bạn đoán số.");
                reset();
            } else if (guess < numberToGuess) {
                displayResult("Quá thấp. Đoán lại.");
            } else {
                displayResult("Quá cao. Đoán lại.");
            }
        } catch (NumberFormatException e) {
            displayError("Vui lòng nhập số hợp lệ");
        }
    }

//    Phương thức này được gọi khi người dùng click vào nút "Guess".
//    Lấy giá trị của guessTextField từ đối tượng TextField và chuyển đổi sang kiểu int thông qua phương thức parseInt().
//    So sánh guess với numberToGuess để kiểm tra xem người dùng đã đoán đúng hay chưa.
//    Nếu guess bằng numberToGuess, hiển thị thông báo "Correct! You guessed the number." và gọi phương thức reset() để bắt đầu một lượt đoán mới.
//    Nếu guess nhỏ hơn numberToGuess, hiển thị thông báo "Too low. Guess again."
//    Nếu guess lớn hơn numberToGuess, hiển thị thông báo "Too high. Guess again."
//    Nếu người dùng nhập vào một giá trị không hợp lệ (không phải số nguyên), bắt lỗi bằng cách hiển thị thông báo "Please enter a valid number."


    @FXML
    private void initialize() {
        reset();
    }

//    Phương thức này được gọi khi lớp NumberController được khởi tạo.
//    Gọi phương thức reset() để tạo số ngẫu nhiên cho lượt đoán đầu tiên.


    private void reset() {
        guessTextField.setText("");
        Random random = new Random();
        numberToGuess = random.nextInt(101);
    }

//    Phương thức này được gọi để bắt đầu một lượt đoán mới.
//    Xóa giá trị của guessTextField.
//    Tạo một số ngẫu nhiên từ 0 đến 100 cho numberToGuess.


    private void displayResult(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Kết quả :");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

//        Phương thức này được sử dụng để hiển thị kết quả đoán số.
//                Tạo một đối tượng Alert với loại thông báo AlertType.INFORMATION.
//                Đặt tiêu đề của hộp thoại là "Result".
//                Đặt nội dung thông báo là message.
//        Hiển thị hộp thoại và đợi cho người dùng đóng lại.

    }

    private void displayError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Lỗi");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

//
//        Phương thức này được sử dụng để hiển thị thông báo lỗi khi người dùng nhập giá trị không hợp lệ.
//                Tạo một đối tượng Alert với loại thông báo AlertType.ERROR.
//                Đặt tiêu đề của hộp thoại là "Error".
//                Đặt nội dung thông báo là message.
//        Hiển thị hộp thoại và đợi cho người dùng đóng lại.

    }

}
