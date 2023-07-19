package bai3;

public class TestEven {
    public static void main(String[] args) {
//        EvenNumbersThread evenThread =new EvenNumbersThread();
//        evenThread.start();
        EvenNumbersRunnable evenRunnable = new EvenNumbersRunnable();
        Thread evenThread = new Thread(evenRunnable);
        evenThread.start();
    }
}
