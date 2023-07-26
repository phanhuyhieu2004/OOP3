package bai3;

import java.util.Scanner;

public class GuessANumber implements Runnable {
    private int guessNumber;
    private int count = 0;

    public GuessANumber(int guessNumber) {
        this.guessNumber = guessNumber;
    }

    @Override
    public void run() {
        int randomNumber = 0;
        do {
            randomNumber = (int) (Math.random() * 100 + 1);
            count++;
            System.out.println(Thread.currentThread().getName() + " đoán số " + randomNumber);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (randomNumber != guessNumber);

        System.out.println(Thread.currentThread().getName() + " đã đoán ra số " + guessNumber + " trong " + count + " lần đếm");
    }
}

 class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập một số nguyên để các thread đoán: ");
        int number = scanner.nextInt();

        GuessANumber guessANumber = new GuessANumber(number);

        Thread thread1 = new Thread(guessANumber);
        Thread thread2 = new Thread(guessANumber);

        thread1.setName("Thread 1");
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();
    }
}
