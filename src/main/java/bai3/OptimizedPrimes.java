package bai3;

public class OptimizedPrimes implements Runnable {
    @Override
    public void run() {
        int number = 2;
        while (true) {
            if (isPrime(number)) {
                System.out.println("Số nguyên tố đã tối ưu hóa : " + number);
            }
            number++;
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        int limit = (int) Math.sqrt(number);
        for (int i = 2; i <= limit; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

