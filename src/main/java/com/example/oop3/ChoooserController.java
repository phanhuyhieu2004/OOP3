package com.example.oop3;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class ChoooserController {
    @FXML
    protected ImageView imageView;

//    Đối tượng này được chú thích bằng @FXML để cho phép nó được tải và quản lý bởi FXMLLoader.
//    Đối tượng này sẽ được sử dụng để hiển thị ảnh đã chọn.


    @FXML
    private AnchorPane ap;

//    Đối tượng này cũng được chú thích bằng @FXML.
//    Đối tượng này đại diện cho AnchorPane được sử dụng để chứa ImageView.


    public void chooseImage(ActionEvent event) {
        Stage stage = (Stage) ap.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Chọn 1 ảnh");
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image file", "*jpeg", "*.jpg", "*.png");
        fileChooser.getExtensionFilters().add(imageFilter);
        File file = fileChooser.showOpenDialog(stage);

//        Phương thức này được gọi khi người dùng click vào nút "Chọn ảnh".
//                Lấy Stage hiện tại từ đối tượng AnchorPane và tạo một đối tượng FileChooser để cho phép người dùng chọn một tệp ảnh.
//        Đặt tiêu đề của hộp thoại chọn tệp là "Chọn 1 ảnh".
//                Đặt bộ lọc cho hộp thoại chọn tệp bằng cách chỉ cho phép các tệp có đuôi là ".jpeg", ".jpg" hoặc ".png".
//                Hiển thị hộp thoại chọn tệp và lấy đường dẫn đến tệp ảnh đã chọn.
//        Nếu người dùng đã chọn một tệp ảnh, tạo một đối tượng Image từ đường dẫn đến tệp ảnh và đặt nó cho đối tượng ImageView.
//
//                Chú ý rằng, trong phương thức chooseImage(), chúng ta sử dụng phương thức toURI().toString() để chuyển đổi đường dẫn đến tệp ảnh thành một chuỗi định dạng URI để tạo một đối tượng Image.

        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        }
    }


}
