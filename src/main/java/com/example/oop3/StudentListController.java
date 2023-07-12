package com.example.oop3;

import com.example.oop3.Student;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentListController implements Initializable {

    @FXML
    private ListView<Student> listView;
//    Đối tượng ListView được chú thích bằng @FXML để cho phép nó được tải và quản lý bởi FXMLLoader.
//
//    Đối tượng này sẽ được sử dụng để hiển thị danh sách sinh viên.


    public ListView<Student> getListView() {
        return listView;
    }

//    Phương thức này trả về đối tượng ListView.
//    Phương thức này được sử dụng để lấy ListView trong StudentApp.


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setCellFactory(param -> new StudentListCell());

//        Phương thức này được gọi khi FXMLLoader đã tải và khởi tạo tất cả các đối tượng trong tệp FXML.
//        Sử dụng phương thức setCellFactory() của ListView để thiết lập một ListCellFactory cho ListView. StudentListCell được sử dụng để tạo một ListCell cho mỗi đối tượng Student trong danh sách.

    }

    private class StudentListCell extends ListCell<Student> {
//        Khai báo lớp StudentListCell là một lớp con của ListCell<Student>.
        private HBox content;
        private Label nameLabel;
        private Label ageLabel;
//        Khai báo các biến thành viên để lưu trữ các thành phần UI.
//
//        content là một HBox chứa các thành phần UI khác.
//        nameLabel để hiển thị tên của sinh viên.
//        ageLabel để hiển thị tuổi của sinh viên.


        public StudentListCell() {
            nameLabel = new Label();
            nameLabel.setFont(Font.font(15));

            ageLabel = new Label();
            ageLabel.setFont(Font.font(15));

            content = new HBox(15);
            content.getChildren().addAll(nameLabel, ageLabel);

//            Phương thức này được sử dụng để khởi tạo các thành phần UI.
//                    Tạo nameLabel và ageLabel với các kích thước phù hợp bằng cách sử dụng phương thức setFont() và khởi tạo content với nameLabel và ageLabel sử dụng phương thức getChildren() và addAll().

        }

        @Override
        protected void updateItem(Student student, boolean empty) {
            super.updateItem(student, empty);

            if (empty || student == null) {
                setText(null);
                setGraphic(null);
            } else {
                nameLabel.setText(student.getName());
                ageLabel.setText("Tuổi : " + student.getAge());

                setText(null);
                setGraphic(content);
            }
        }

//        Phương thức này được gọi mỗi khi một đối tượng Student được hiển thị trong ListView.
//        Nếu student là null hoặc empty, xóa nội dung của ô hiển thị bằng cách thiết lập setText(null) và setGraphic(null).
//        Nếu student không null, cập nhật nameLabel và ageLabel với thông tin của student và thiết lập content làm nội dung của ô hiển thị bằng cách thiết lập setText(null) và setGraphic(content).

    }
}

