package bai7;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class JavaReflectionTest{
    public static void main(String[] args) throws ClassNotFoundException {
// Lấy tên của class
        Class<?> newClass = new JavaReflection().getClass();
        System.out.println("Tên class là :" + newClass.getName());

        // Lấy thông số thuộc tính của lớp
        int modifiers = newClass.getModifiers();
        System.out.println("Modifiers: " + modifiers);

        // Lấy danh sách các trường public của lớp
        Field[] fields = newClass.getFields();
        System.out.println("Trường public :");
        for (Field field : fields) {
            System.out.println("- " + field.getName());
        }

        // Lấy danh sách các phương thức public của lớp
        Method[] methods = newClass.getMethods();
        System.out.println(" Phương thức public : ");
        for (Method method : methods) {
            System.out.println("- " + method.getName());
        }

        // Lấy danh sách các hàm khởi tạo public của lớp
        Constructor<?>[] constructors = newClass.getConstructors();
        System.out.println("Các hàm khởi tạo public :");
        for (Constructor<?> constructor : constructors) {
            System.out.println("- " + constructor.getName());
        }
    }



}

