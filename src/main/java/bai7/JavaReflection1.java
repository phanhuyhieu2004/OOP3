package bai7;

import java.lang.reflect.Constructor;

public class JavaReflection1 {
    public static void main(String[] args) {
        // Lớp mẫu để liệt kê Constructor
        Class<?> clazz = MyClass.class;

        // Lấy danh sách Constructor
        Constructor<?>[] constructors = clazz.getConstructors();

        // Liệt kê thông tin về các Constructor
        for (Constructor<?> constructor : constructors) {
            System.out.println("Constructor: " + constructor.getName());

            // Lấy thông tin về các tham số của Constructor
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            System.out.print("Parameters: ");
            for (Class<?> parameterType : parameterTypes) {
                System.out.print(parameterType.getSimpleName() + " ");
            }
            System.out.println();
        }
    }
}

class MyClass {
    public MyClass() {
    }

    public MyClass(int value) {
    }

    public MyClass(String name, int age) {
    }
}


