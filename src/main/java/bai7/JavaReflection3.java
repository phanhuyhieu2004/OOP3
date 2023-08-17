package bai7;

import java.lang.reflect.Method;

public class JavaReflection3 {
    public static void main(String[] args) throws Exception {
        // Tạo một đối tượng động
        MyClass3 obj = new MyClass3();

        // Lấy đối tượng Class của đối tượng động
        Class<?> clazz = obj.getClass();

        // Tên phương thức cần gọi
        String methodName = "dynamicMethod";

        // Lấy đối tượng Method của phương thức cần gọi
        Method method = clazz.getMethod(methodName);

        // Gọi và thực thi phương thức trên đối tượng động
        method.invoke(obj);
    }
}

class MyClass3 {
    public void dynamicMethod() {
        System.out.println("This is a dynamic method.");
    }
}

