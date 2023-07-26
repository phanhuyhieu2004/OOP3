package bai3;

public class LazyPrimeFactorization implements Runnable {
    private int n;

    public LazyPrimeFactorization(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.println(i + " số nguyên tố là.");
            }
        }
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class OptimizedPrimeFactorization implements Runnable {
    private int n;

    public OptimizedPrimeFactorization(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.println(i + " số nguyên tố là.");
            }
        }
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

 class mains {
    public static void main(String[] args) {
        int n = 100;

        LazyPrimeFactorization lazyPrime= new LazyPrimeFactorization(n);
        OptimizedPrimeFactorization optimizedPrime = new OptimizedPrimeFactorization(n);

        Thread lazyThread = new Thread(lazyPrime);
        Thread optimizedThread = new Thread(optimizedPrime);

        lazyThread.start();
        optimizedThread.start();
    }
}