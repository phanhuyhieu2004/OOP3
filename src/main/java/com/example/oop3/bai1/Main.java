package com.example.oop3.bai1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private TableView<SinhVien> tableView;
    private TextField txtHoTen;
    private TextField txtTuoi;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        tableView = new TableView<>();

        TableColumn<SinhVien, String> colHoTen = new TableColumn<>("Họ Tên");
        colHoTen.setCellValueFactory(new PropertyValueFactory<>("hoTen"));

        TableColumn<SinhVien, Integer> colTuoi = new TableColumn<>("Tuổi");
        colTuoi.setCellValueFactory(new PropertyValueFactory<>("tuoi"));

        tableView.getColumns().add(colHoTen);
        tableView.getColumns().add(colTuoi);

        txtHoTen = new TextField();
        txtTuoi = new TextField();

        Button btnThem = new Button("Thêm");
        btnThem.setOnAction(event -> themSinhVien());

        Button btnSua = new Button("Sửa");
        btnSua.setOnAction(event -> suaSinhVien());

        Button btnXoa = new Button("Xóa");
        btnXoa.setOnAction(event -> xoaSinhVien());

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(tableView, txtHoTen, txtTuoi, btnThem, btnSua, btnXoa);

        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Quản lý Sinh Viên");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void themSinhVien() {
        String hoTen = txtHoTen.getText();
        int tuoi = Integer.parseInt(txtTuoi.getText());

        SinhVien sinhVien = new SinhVien(hoTen, tuoi);
        tableView.getItems().add(sinhVien);

        txtHoTen.clear();
        txtTuoi.clear();
    }

    private void suaSinhVien() {
        SinhVien selectedSinhVien = tableView.getSelectionModel().getSelectedItem();
        if (selectedSinhVien != null) {
            String hoTen = txtHoTen.getText();
            int tuoi = Integer.parseInt(txtTuoi.getText());

            selectedSinhVien.setHoTen(hoTen);
            selectedSinhVien.setTuoi(tuoi);

            tableView.refresh();

            txtHoTen.clear();
            txtTuoi.clear();
        }
    }

    private void xoaSinhVien() {
        SinhVien selectedSinhVien = tableView.getSelectionModel().getSelectedItem();
        if (selectedSinhVien != null) {
            tableView.getItems().remove(selectedSinhVien);
        }
    }

}
