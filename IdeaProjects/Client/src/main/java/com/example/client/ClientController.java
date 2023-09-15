package com.example.client;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ClientController implements Initializable{
    @FXML
    private Label label;
    @FXML
    private TextField tfMessage;
    @FXML
    public Button buttonSend;
    private Client2 client;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            client = new Client2(new Socket("localhost", 8080));
        } catch (IOException e) {
            e.printStackTrace();
        }
        buttonSend.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ImportToDataBase importToDataBase = new ImportToDataBase();
                    String message = tfMessage.getText();
                    client.SendMessageToServer(message);
                    importToDataBase.addDatabase("Client", message);
                    if (message.equalsIgnoreCase("exit")) {
                        importToDataBase.deleteData();
                    }
                    client.readFromServer(label);
                    StringBuilder listMessage = importToDataBase.ReadMessageToDatabase();
                    label.setText(String.valueOf(listMessage));
                    tfMessage.clear();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
