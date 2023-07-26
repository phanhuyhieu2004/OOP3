package bai3.Testlan1;

public class LazyPrimeFactorizations implements Runnable {

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        int count = 0;
        int number = 2;

        while(count < 3000) {
            if(isPrime(number)) {
                System.out.println(number);
                count++;
            }
            number++;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("LazyPrimeFactorization hoàn thành sau: " + (endTime - startTime) + " milliseconds");
    }

    private boolean isPrime(int number) {
        if(number < 2) {
            return false;
        }

        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) {
                return false;
            }
        }

        return true;
    }
}

 class OptimizedPrimeFactorizations implements Runnable {

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        int count = 0;
        int number = 2;
        int[] primes = new int[3000];

        while(count < 3000) {
            if(isPrime(number, primes, count)) {
                System.out.println(number);
                primes[count] = number;
                count++;
            }
            number++;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("OptimizedPrimeFactorization hoàn thành sau: " + (endTime - startTime) + " milliseconds");
    }

    private boolean isPrime(int number, int[] primes, int count) {
        if(number < 2) {
            return false;
        }

        for(int i = 0; i < count; i++) {
            if(number % primes[i] == 0) {
                return false;
            }
        }

        return true;
    }
}

 class Mains {

    public static void main(String[] args) {
      LazyPrimeFactorizations lazyPrime=new LazyPrimeFactorizations();
        OptimizedPrimeFactorizations optimizedPrime=new OptimizedPrimeFactorizations();
        Thread thread1=new Thread(lazyPrime);
        thread1.start();
        Thread thread2=new Thread(optimizedPrime);
        thread2.start();
    }
}

