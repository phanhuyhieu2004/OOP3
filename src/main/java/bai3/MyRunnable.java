package bai3;


public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable Start");
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("MyRunnable End");
    }
}

