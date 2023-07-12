package com.example.oop3.bai1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Đăng nhập");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
//    Trong JavaFX, một số thành phần trên giao diện người dùng được sử dụng để chứa các thành phần khác. Ví dụ, trong trường hợp này, tệp FXML login.fxml có thể chứa nhiều thành phần trên giao diện người dùng, chẳng hạn như các TextField, Button, Label và Pane.
//
//    Do đó, khi tải tệp FXML, chúng ta cần chuyển đổi nó thành một đối tượng Parent, không phải là một đối tượng Node cụ thể. Đối tượng Parent là một lớp trừu tượng trong JavaFX, được sử dụng để đại diện cho các thành phần chứa khác nhau trên giao diện người dùng, bao gồm cả các Pane, Group và Scene.
//
//    Nếu tệp FXML chỉ chứa một đối tượng Node duy nhất, chúng ta có thể chuyển đổi nó thành đối tượng cụ thể tương ứng với loại của nó, chẳng hạn như TextField, Button hoặc Label. Tuy nhiên, trong trường hợp này, chúng ta cần chuyển đổi tệp FXML thành một đối tượng Parent để đại diện cho toàn bộ giao diện người dùng được định nghĩa trong tệp FXML.


    public static void main(String[] args) {
        launch(args);
    }

}