package com.example.oop3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    @FXML
    private TableView<Student> table;


    @FXML
    private TableColumn<Student, Integer> idColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> emailColumn;

    @FXML
    private TableColumn<Student, Integer> ageColumn;

    private ObservableList<Student> studentList;

    @FXML
    private TextField idText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField emailText;

    @FXML
    private TextField ageText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentList = FXCollections.observableArrayList();
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        table.setItems(studentList);
    }

    public void add(ActionEvent e) {
        int id = Integer.parseInt(idText.getText());
        String name = nameText.getText();
        String email = emailText.getText();
        int age = Integer.parseInt(ageText.getText());

        Student newStudent = new Student(id, name, email, age);
        studentList.add(newStudent);

        clearInputs();
    }

    public void delete(ActionEvent e) {
        Student selected = table.getSelectionModel().getSelectedItem();
        studentList.remove(selected);
    }

    private void clearInputs() {
        idText.clear();
        nameText.clear();
        emailText.clear();
        ageText.clear();
    }

}