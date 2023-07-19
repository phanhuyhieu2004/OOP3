package bai3;

public class TestCoutdown {

        public static void main(String[] args) {
//            CountdownThread countdownThread = new CountdownThread();
//            countdownThread.start();
            CountdownRunnable countdownRunnable = new CountdownRunnable();
            Thread countdownThread = new Thread(countdownRunnable);
            countdownThread.start();

        }

}
