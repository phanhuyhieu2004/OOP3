package com.example.client;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class ServerController implements Initializable{
    @FXML
    private Label label;
    @FXML
    private TextField tfMessage;
    @FXML
    private Button buttonSend;
    private Server2 server;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            server = new Server2(new ServerSocket(8080));
        } catch (IOException e) {
            e.printStackTrace();
        }
        buttonSend.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String textMessage = tfMessage.getText();
                    server.SendMessageToClient(textMessage);
                    server.readFromClient(label);
                    ImportToDataBase importToDataBase = new ImportToDataBase();
                    importToDataBase.addDatabase("Server", textMessage);
                    if (textMessage.equalsIgnoreCase("exit")){
                        importToDataBase.deleteData();
                    }
                    StringBuilder listMessage = importToDataBase.ReadMessageToDatabase();
                    label.setText(String.valueOf(listMessage));
                    tfMessage.clear();
                }catch (IOException e){
                    System.out.println(e);
                }catch (SQLException e){
                    System.out.println(e);
                }
            }
        });
    }
}