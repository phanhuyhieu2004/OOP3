package bai3;

public class NumberGenerator implements Runnable {
    @Override
    public void run() {
//        Phương thức run() là phương thức được ghi đè (override) từ giao diện Runnable. Nó được gọi khi thread bắt đầu thực thi. Trong phương thức này, chúng ta thực hiện các tác vụ cần thiết.
        for (int i = 1; i <= 10; i++) {
            System.out.println("Thread " + Thread.currentThread().hashCode() + ": " + i);
//            Dòng này in ra thông tin về thread hiện tại và số đếm i. Thread.currentThread() trả về đối tượng thread đang thực thi phương thức run() của lớp NumberGenerator. hashCode() trả về mã băm (hash code) của đối tượng thread đó, đảm bảo rằng mỗi thread sẽ có một mã băm duy nhất.
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//    Trong vòng lặp for, chúng ta in ra thông tin về thread hiện tại và số đếm i. Sau đó, chúng ta sử dụng phương thức sleep() để tạm dừng thread trong 500 millisecond (0,5 giây).

class main {
    public static void main(String[] args) {
        NumberGenerator generator1 = new NumberGenerator();
        NumberGenerator generator2 = new NumberGenerator();
        Thread thread1 = new Thread(generator1);
        Thread thread2 = new Thread(generator2);
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
//        Chúng ta sử dụng phương thức setPriority() để thiết lập độ ưu tiên cho hai thread. Thread 1 có độ ưu tiên thấp nhất (MIN_PRIORITY), trong khi thread 2 có độ ưu tiên cao nhất (MAX_PRIORITY).
//        Trong đoạn mã này, Thread.currentThread() trả về đối tượng Thread đang thực thi phương thức run() của lớp NumberGenerator. Phương thức hashCode() được gọi trên đối tượng Thread đó để trả về một mã băm (hash code) duy nhất để định danh đối tượng đó.
//
//        Mã băm là một số nguyên duy nhất được sinh ra bởi hàm băm (hash function) từ các thuộc tính của đối tượng. Trong trường hợp này, mã băm đại diện cho đối tượng Thread đang thực thi phương thức run(). Mã băm được sử dụng để định danh đối tượng và đảm bảo rằng mỗi đối tượng có một mã băm duy nhất.
//
//        Do đó, dòng mã System.out.println("Thread " + Thread.currentThread().hashCode() + ": " + i); sẽ in ra thông tin về thread hiện tại (được định danh bằng mã băm) và giá trị của biến i. Ví dụ, nếu thread hiện tại có mã băm là 1234 và i có giá trị là 5, thì dòng mã đó sẽ in ra chuỗi "Thread 1234: 5".
        thread1.start();
        thread2.start();
    }
}