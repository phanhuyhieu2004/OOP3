package bai7;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class JavaReflection2 {
    public static void main(String[] args) throws NoSuchMethodException {
        // Lớp mẫu để kiểm tra phương thức
        Class<?> clazz = MyClass2.class;

        // Tên phương thức cần kiểm tra
        String methodName = "staticMethod";

        // Kiểm tra xem phương thức có phải là static hay không
        Method method = clazz.getMethod(methodName);
        boolean isStatic = Modifier.isStatic(method.getModifiers());

        if (isStatic) {
            System.out.println(methodName + " is a static method.");
        } else {
            System.out.println(methodName + " is not a static method.");
        }
    }
}

class MyClass2 {
    public static void staticMethod() {
    }

    public void instanceMethod() {
    }
}

