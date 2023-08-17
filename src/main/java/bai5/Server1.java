//package bai5;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.net.DatagramPacket;
//import java.net.DatagramSocket;
//import java.net.InetAddress;
//
//public class Server1 {
//    public static void main(String[] args) {
//        DatagramSocket serverSocket = null;
//        DatagramPacket receivePacket = null;
//        byte[] receiveData, fileData;
//        try {
//            // Tạo socket cho máy chủ
//            serverSocket = new DatagramSocket(12345);
//            System.out.println("Máy chủ đã khởi động...");
//
//            // Nhận yêu cầu gửi file từ máy khách
//            receiveData = new byte[1024];
//            receivePacket = new DatagramPacket(receiveData, receiveData.length);
//            serverSocket.receive(receivePacket);
//            InetAddress clientIP = receivePacket.getAddress();
//            int clientPort = receivePacket.getPort();
//            System.out.println("Máy khách đã kết nối với máy chủ.");
//
//            // Đọc thông tin về file cần gửi
//            byte[] fileInfoBytes = receivePacket.getData();
//            FileInfo fileInfo = (FileInfo) SerializationUtils.deserialize(fileInfoBytes);
//
//            // Tạo file trên ổ đĩa để ghi dữ liệu
//            FileOutputStream fileOutputStream = new FileOutputStream(fileInfo.getFilename());
//
//            // Nhận các phần dữ liệu của file từ máy khách và ghi vào file trên ổ đĩa
//            int numOfParts = fileInfo.getNumOfParts();
//            int lastPartSize = fileInfo.getLastPartSize();
//            for (int i = 0; i < numOfParts; i++) {
//                if (i == numOfParts - 1) {
//                    fileData = new byte[lastPartSize];
//                } else {
//                    fileData = new byte[32768];
//                }
//                receivePacket = new DatagramPacket(fileData, fileData.length);
//                serverSocket.receive(receivePacket);
//                fileOutputStream.write(fileData);
//            }
//
//            // Đóng kết nối và giải phóng tài nguyên
//            fileOutputStream.close();
//            serverSocket.close();
//            System.out.println("Đã nhận file thành công từ máy khách.");
//        } catch (IOException e) {
//            System.out.println("Lỗi: " + e.getMessage());
//        }
//    }
//}