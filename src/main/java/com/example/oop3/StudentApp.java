package com.example.oop3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("student.fxml"));
//        Tạo một đối tượng FXMLLoader. getResource() được sử dụng để tải tệp FXML chứa giao diện người dùng từ cùng gói với lớp StudentApp.
        VBox root = loader.load();
//        Sử dụng phương thức load() của FXMLLoader để tạo đối tượng giao diện từ tệp FXML và lấy đối tượng giao diện chính (tức là VBox) của nó.
        StudentListController controller = loader.getController();
//        Sử dụng phương thức getController() của FXMLLoader để lấy đối tượng StudentListController. Đối tượng này sẽ được sử dụng để thêm các đối tượng Student vào danh sách ListView.

        controller.getListView().getItems().addAll(
                new Student(1, "John Doe", 20),
                new Student(2, "Jane Smith", 22),
                new Student(3, "David Johnson", 19)
        );
//        Thêm các đối tượng Student vào danh sách ListView của StudentListController.



        primaryStage.setTitle("Danh sách Sinh viên :");
        primaryStage.setScene(new Scene(root, 200, 300));
        primaryStage.show();
    }
}


