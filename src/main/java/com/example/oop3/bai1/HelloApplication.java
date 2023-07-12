package com.example.oop3.bai1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        Phương thức start() là phương thức chính của chương trình, được gọi khi ứng dụng được khởi chạy. Phương thức này nhận vào một đối tượng Stage (cửa sổ ứng dụng) và ném ra một ngoại lệ IOException. Để ghi đè lên phương thức start() của class Application, chúng ta sử dụng annotation "@Override".
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Trong phương thức start(), chúng ta sử dụng FXMLLoader để tải nội dung của file "hello-view.fxml" (file FXML chứa thông tin về giao diện người dùng) và tạo một đối tượng FXMLLoader để xử lý file này.
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        Sau khi tải nội dung của file FXML, chúng ta tạo một đối tượng Scene (một cảnh trong ứng dụng), với kích thước là 320x240 pixel, bằng cách sử dụng phương thức load() của đối tượng FXMLLoader.

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
//        Cuối cùng, chúng ta đặt tiêu đề cho cửa sổ ứng dụng bằng phương thức setTitle(), đặt Scene cho Stage bằng phương thức setScene(), và hiển thị cửa sổ ứng dụng bằng phương thức show() của Stage.
    }

    public static void main(String[] args) {
        launch();
    }
//    phương thức main() chỉ gọi phương thức launch() của lớp Application để khởi chạy ứng dụng JavaFX. Phương thức launch() được kế thừa từ lớp Application và nó sẽ xử lý công việc khởi tạo ứng dụng, khởi tạo Stage và gọi phương thức start() để bắt đầu hiển thị giao diện người dùng. Trong trường hợp này, phương thức start() đã được định nghĩa trong class HelloApplication và sẽ được gọi bởi launch() để hiển thị giao diện người dùng.
}