package bai3.Testlan1;

public class EvenNumbersThreadss extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i += 2) {
            System.out.println("Số lẻ là: " + i);
        }
    }

}

class TestEvens {
    public static void main(String[] args) {
        EvenNumbersThreadss evenNumbers = new EvenNumbersThreadss();
        evenNumbers.start();
    }
}
