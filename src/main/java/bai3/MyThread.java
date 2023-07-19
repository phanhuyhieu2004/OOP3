package bai3;


public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread Start");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println(myThread.getState());
    }
}

