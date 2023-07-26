package bai3.Testlan1;

public class CountThread1to5 extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Luồng  từ 1 đến 5 là :" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class CountThread6to10 extends Thread {
    @Override
    public void run() {
        for (int i = 6; i <= 10; i++) {
            System.out.println("Luồng từ 6 đến 10 là :" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TestCount {
    public static void main(String[] args) {
        CountThread1to5 thread1 = new CountThread1to5();
        CountThread6to10 thread2 = new CountThread6to10();
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}




