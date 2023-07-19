package bai3;

public class OddThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i += 2) {
            System.out.println("Số lẻ là: " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

 class EvenThread extends Thread {
    @Override
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println("Số chẵn là: " + i);
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

 class TestThread {
    public static void main(String[] args) {
        OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();

        oddThread.start();
        try {
            oddThread.join(); // Đợi OddThread hoàn thành trước khi start EvenThread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        evenThread.start();
    }
}