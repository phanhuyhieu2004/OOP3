package bai4;

public class run {
    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client();

        Thread thread1 = new Thread(server);
        Thread thread2 = new Thread(client);

        thread1.start();
        thread2.start();
    }
}
