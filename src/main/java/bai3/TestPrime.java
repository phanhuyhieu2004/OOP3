package bai3;

public class TestPrime {

        public static void main(String[] args) {
            LazyPrimeFactorization lazyPrimeFactorization = new LazyPrimeFactorization();
            OptimizedPrimes optimizedPrime = new OptimizedPrimes();
            Thread thread1 = new Thread(lazyPrimeFactorization);
            Thread thread2 = new Thread(optimizedPrime);
            thread1.start();
            thread2.start();
        }


}
