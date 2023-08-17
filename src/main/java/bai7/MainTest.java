package bai7;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Annotation đánh dấu phương thức ghi đè (override)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface OverrideMethod {
}

// Annotation đánh dấu phương thức đã cũ
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface DeprecatedMethod {
}

// Annotation đánh dấu phương thức getter cho một thuộc tính
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Getter {
}

// Annotation đánh dấu phương thức setter cho một thuộc tính
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Setter {
}

class ParentClass {
    @OverrideMethod
    public void someMethod() {
        // Phương thức ghi đè
    }

    @DeprecatedMethod
    public void oldMethod() {
        // Phương thức đã cũ
    }

    public void normalMethod() {
        // Phương thức bình thường
    }
}

class ChildClass extends ParentClass {
    @Override
    @DeprecatedMethod
    public void someMethod() {
        // Phương thức ghi đè và đã cũ
    }
}

class MyClass4 {
    private int value;

    @Getter
    public int getValue() {
        return value;
    }

    @Setter
    public void setValue(int value) {
        this.value = value;
    }
}

public class MainTest {
    public static void main(String[] args) {
        // Kiểm tra các annotation trên phương thức
        Method[] methods = ChildClass.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(OverrideMethod.class)) {
                System.out.println(method.getName() + " is an overridden method.");
            }
            if (method.isAnnotationPresent(DeprecatedMethod.class)) {
                System.out.println(method.getName() + " is a deprecated method.");
            }
        }

        // Sử dụng phương thức getter và setter được đánh dấu bằng annotation
        MyClass obj = new MyClass();
        Method[] objMethods = obj.getClass().getDeclaredMethods();
        for (Method method : objMethods) {
            if (method.isAnnotationPresent(Getter.class)) {
                System.out.println(method.getName() + " is a getter method.");
            }
            if (method.isAnnotationPresent(Setter.class)) {
                System.out.println(method.getName() + " is a setter method.");
            }
        }
    }
}
