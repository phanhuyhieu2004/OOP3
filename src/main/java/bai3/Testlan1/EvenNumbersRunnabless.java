package bai3.Testlan1;

public class EvenNumbersRunnabless implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 20; i += 2) {
            System.out.println("Số lẻ là: " + i);
        }
    }
}

class TestEvenss {

    public static void main(String[] args) {
        EvenNumbersRunnabless evenNumbersRunnabless = new EvenNumbersRunnabless();
        Thread evenThread = new Thread(evenNumbersRunnabless);
        evenThread.start();
    }
}
