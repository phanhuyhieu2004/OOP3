package com.example.oop3.bai1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AgeApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Phương thức start() được ghi đè từ lớp Application. Nó là phương thức đầu tiên được gọi khi ứng dụng được khởi động. Trong phương thức này, chúng ta khởi tạo cửa sổ chính của ứng dụng (primaryStage) và tải tệp FXML để hiển thị UI.
        Parent root = FXMLLoader.load(getClass().getResource("age.fxml"));
//        Đây là dòng code để tải tệp FXML gọi là age.fxml. Phương thức getClass().getResource() được sử dụng để tìm kiếm tệp FXML trong thư mục resources của ứng dụng.
        primaryStage.setTitle("Tính tuổi");
//        Đây là dòng code để đặt tiêu đề cho cửa sổ chính.
        primaryStage.setScene(new Scene(root, 600, 500));
//        Đây là dòng code để thiết lập cảnh cho cửa sổ chính. Kích thước của cảnh được đặt là 600x500 và nội dung được đặt là root, tức là nội dung được tải từ tệp FXML.
        primaryStage.show();
//        Đây là dòng code để hiển thị cửa sổ chính của ứng dụng. Sau khi được gọi, ứng dụng sẽ được hiển thị và người dùng có thể tương tác với nó.
    }
//    primaryStage là một đối tượng của lớp Stage trong JavaFX, đại diện cho cửa sổ chính của ứng dụng. Stage là một thành phần quan trọng của JavaFX và được sử dụng để hiển thị cửa sổ, cảnh và các nút điều khiển của ứng dụng.

//    Trong phương thức start() của ứng dụng, chúng ta tạo một đối tượng primaryStage của lớp Stage bằng cách truyền vào nó thông tin cần thiết để tạo ra cửa sổ, chẳng hạn như tiêu đề, nội dung và kích thước của cửa sổ. Sau đó, chúng ta sử dụng primaryStage để thiết lập cảnh và hiển thị cửa sổ chính của ứng dụng.

    public static void main(String[] args) {
        launch(args);
    }
}