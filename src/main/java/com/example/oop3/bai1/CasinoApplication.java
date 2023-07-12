package com.example.oop3.bai1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CasinoApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("casino.fxml"));
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Máy tính");
        primaryStage.show();
//        Trong đoạn code AnchorPane root = FXMLLoader.load(getClass().getResource("casino.fxml"));, FXMLLoader sử dụng để tải tệp FXML casino.fxml, đóng vai trò là một mô tả của giao diện người dùng được tạo ra bằng công cụ thiết kế giao diện của JavaFX Scene Builder. Sau khi tệp FXML được tải, nó được chuyển đổi thành một đối tượng AnchorPane bằng cách sử dụng phương thức load() của FXMLLoader. Do đó, biến root được khai báo với kiểu dữ liệu AnchorPane để lưu trữ đối tượng AnchorPane được tạo ra từ tệp FXML.
//
//                Tóm lại, lý do sử dụng AnchorPane trong đoạn mã này là để định vị các thành phần trên giao diện người dùng được tạo ra từ tệp FXML casino.fxml bằng cách gắn chúng vào các điểm neo trên cửa sổ ứng dụng.
    }

    public static void main(String[] args) {
        launch(args);
    }

}