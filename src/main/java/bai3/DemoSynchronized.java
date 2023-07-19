package bai3;

public class DemoSynchronized {
    public static synchronized void commonResource() {
        for (int i = 0; i < 100000; i++) {
            // Không làm gì cả, chỉ chạy vòng lặp để đảm
            // bảo phương thức này sống lâu một tí,
            // để cho có Thread dùng đến và các Thread
            // khác phải chờ đợi
        }
    }
}
