package com.example.oop3.bai1;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BMIController {

    @FXML
    private TextField weightTextField;
//    Đây là một trường dữ liệu của lớp BMIController, được chú thích bởi @FXML để đánh dấu rằng trường này được liên kết với một thành phần trong tệp FXML.
//    Trong trường hợp này, weightTextField là một TextField được sử dụng để nhập cân nặng

    @FXML
    private TextField heightTextField;

//    Đây là một trường dữ liệu của lớp BMIController, được chú thích bởi @FXML để đánh dấu rằng trường này được liên kết với một thành phần trong tệp FXML.
//    Trong trường hợp này, heightTextField là một TextField được sử dụng để nhập chiều cao.


    @FXML
    private Button calculateButton;

//    Đây là một trường dữ liệu của lớp BMIController, được chú thích bởi @FXML để đánh dấu rằng trường này được liên kết với một thành phần trong tệp FXML.
//    Trong trường hợp này, calculateButton là một Button được sử dụng để tính toán chỉ số BMI.


    @FXML
    private Label resultLabel;

//    Đây là một trường dữ liệu của lớp BMIController, được chú thích bởi @FXML để đánh dấu rằng trường này được liên kết với một thành phần trong tệp FXML.
//    Trong trường hợp này, resultLabel là một Label được sử dụng để hiển thị kết quả chỉ số BMI.


    @FXML
    public void calculateBMI() {
        double weight = Double.parseDouble(weightTextField.getText());
        double height = Double.parseDouble(heightTextField.getText());
        double bmi = weight / (height * height);

        String result = String.format("BMI của bạn là: %.2f", bmi);
        resultLabel.setText(result);

//        Đây là một phương thức của lớp BMIController, được đánh dấu bởi @FXML để đánh dấu rằng phương thức này sẽ được gọi khi người dùng nhấn vào nút tính toán BMI.
//        Trong phương thức này, trước tiên chúng ta lấy giá trị nhập vào từ hai trường weightTextField và heightTextField và chuyển đổi chúng thành số thực bằng phương thức Double.parseDouble().
//                Tiếp theo, chúng ta tính toán chỉ số BMI bằng cách chia cân nặng cho bình phương chiều cao.
//        Sau đó, chúng ta sử dụng String.format() để định dạng chuỗi kết quả, với chỉ số BMI được làm tròn đến hai chữ số thập phân.
//        Cuối cùng, chúng ta cập nhật nội dung của nhãn resultLabel bằng kết quả tính toán chỉ số BMI bằng phương thức setText().

    }
}


