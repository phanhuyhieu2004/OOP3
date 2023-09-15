package com.example.oop3.cs;

import com.example.oop3.Server;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button button_send;
    @FXML
    private TextField tf_message;
    @FXML
    private VBox vbox_message;

    @FXML
    private Server server;
//    server được sử dụng để nhận tin nhắn từ client và gửi tin nhắn tới client thông qua các phương thức đã được định nghĩa trong lớp Server.

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            server = new Server(new ServerSocket(8136));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi tạo server");
        }

        server.receiveMessageFromClient(vbox_message);
//        nhận tin nhắn từ một client và hiển thị nó trong vbox_message.
        button_send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ImportToDatabase importToDatabase = new ImportToDatabase();

                String messageToSend = tf_message.getText();
//                Lấy nội dung của tf_message, một trường nhập liệu (TextField) có tên tf_message, và gán nó cho biến messageToSend. tf_message.getText() trả về chuỗi chứa nội dung đã nhập vào tf_message.
                if (!messageToSend.isEmpty()) {//

                    HBox hBox1 = new HBox();

                    hBox1.getStyleClass().add("hBox1");
                    Text text = new Text(messageToSend);
                    TextFlow textFlow1 = new TextFlow(text);
                    textFlow1.getStyleClass().add("textFlow1");

                    hBox1.getChildren().add(textFlow1);

                    vbox_message.getChildren().add(hBox1);
                    server.sendMessageToClient(messageToSend);

                    try {
                        importToDatabase.addToDatabase("Server", messageToSend);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    if (messageToSend.equalsIgnoreCase("delete")) {
                        try {
                            importToDatabase.deleteAll();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
//                    try {
//                        StringBuilder listMessage = importToDatabase.readMessages();
//                        Text textList = new Text(String.valueOf(listMessage));
//                        vbox_message.getChildren().add(textList);
//
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }

                    tf_message.clear();


                }
            }


        });

    }

    public static void addLabel(String messageFromClient, VBox vBox) {
        HBox hBox2 = new HBox();

        hBox2.getStyleClass().add("hBox2");

        Text text = new Text(messageFromClient);
        TextFlow textFlow2 = new TextFlow(text);
        textFlow2.getStyleClass().add("textFlow2");


        hBox2.getChildren().add(textFlow2);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vBox.getChildren().add(hBox2);
            }
        });

    }
}

//    Phương thức initialize() trong đoạn mã trên đảm bảo rằng một đối tượng Server được tạo và kết nối đến cổng 8136 khi giao diện FXML được nạp. Điều này cho phép ứng dụng sẵn sàng nhận và gửi tin nhắn qua kết nối mạng.
