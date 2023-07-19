package com.example.oop3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentControllers {
    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, Integer> idColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> classColumn;

    @FXML
    private TableColumn<Student, Double> scoreColumn;

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField classField;

    @FXML
    private TextField genderField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField scoreField;

    private ObservableList<Student> students = FXCollections.observableArrayList();

    public void initialize() {
        // Initialize table columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        classColumn.setCellValueFactory(new PropertyValueFactory<>("className"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

        // Set table data
        studentTable.setItems(students);
    }

    @FXML
    void addStudent(ActionEvent event) {
        // Get input values from fields
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String className = classField.getText();
        String gender = genderField.getText();
        String address = addressField.getText();
        double score = Double.parseDouble(scoreField.getText());

        // Create new student object
        Student student = new Student(id, name, className, gender, address, score);

        // Add student to list and table
        students.add(student);
        studentTable.setItems(students);

        // Clear input fields
        idField.clear();
        nameField.clear();
        classField.clear();
        genderField.clear();
        addressField.clear();
        scoreField.clear();
    }

    @FXML
    void editStudent(ActionEvent event) {
        // Get selected student from table
        Student student = studentTable.getSelectionModel().getSelectedItem();

        if (student != null) {
            // Get updated values from fields
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String className = classField.getText();
            String gender = genderField.getText();
            String address = addressField.getText();
            double score = Double.parseDouble(scoreField.getText());

            // Update student object
            student.setId(id);
            student.setName(name);
            student.setClassName(className);
            student.setGender(gender);
            student.setAddress(address);
            student.setScore(score);

            // Update table
            studentTable.refresh();

            // Clear input fields
            idField.clear();
            nameField.clear();
            classField.clear();
            genderField.clear();
            addressField.clear();
            scoreField.clear();
        }
    }

    @FXML
    void deleteStudent(ActionEvent event) {
        // Get selected student from table
        Student student = studentTable.getSelectionModel().getSelectedItem();

        if (student != null) {
            // Remove student from list and table
            students.remove(student);
            studentTable.setItems(students);

            // Clear input fields
            idField.clear();
            nameField.clear();
            classField.clear();
            genderField.clear();
            addressField.clear();
            scoreField.clear();
        }
    }
}