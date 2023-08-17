package bai7;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldExample {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // Lấy đối tượng Class của lớp MyClass
        Class<MyClass1> clazz = MyClass1.class;

        // Lấy danh sách các trường public của lớp
        Field[] fields = clazz.getFields();

        // Duyệt qua từng trường và hiển thị thông tin
        for (Field field : fields) {
            // Lấy tên trường
            String fieldName = field.getName();
            System.out.println("Tên trường: " + fieldName);

            // Lấy kiểu dữ liệu của trường
            Class<?> fieldType = field.getType();
            System.out.println("Kiểu dữ liệu của trường: " + fieldType.getName());

            // Lấy thông số thuộc tính của trường
            int modifiers = field.getModifiers();
            System.out.println("Modifiers: " + Modifier.toString(modifiers));

            // Tạo đối tượng MyClass
            MyClass1 instance = new MyClass1();

            // Lấy giá trị của trường sau khi thay đổi
            Object fieldValue = field.get(instance);
            System.out.println("Giá trị của trường: " + fieldValue);

            System.out.println();
        }
    }
}

class MyClass1 {
    public String publicField = "Public Field";
    private int privateField = 42;
    public final String finalField = "Final Field";

    public void printFields() {
        System.out.println(publicField);
        System.out.println(privateField);
        System.out.println(finalField);
    }
}



