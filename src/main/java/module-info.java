module com.example.oop3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.oop3 to javafx.fxml;

    opens com.example.oop3.bai1 to javafx.fxml;
    exports com.example.oop3.bai1;
    exports com.example.oop3;


}