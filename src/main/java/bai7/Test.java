package bai7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface DeprecatedAPI {
    String version() default "";
    String reason() default "";
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    @DeprecatedAPI(version = "1.0", reason = "Use the 'add' method instead")
    public int sum(int a, int b) {
        return a + b;
    }
}

public class Test {
    public static void main(String[] args) throws NoSuchMethodException {
        Calculator calculator = new Calculator();

        int result = calculator.add(2, 3);
        System.out.println("Addition: " + result);

        // Kiểm tra xem phương thức sum() có bị đánh dấu là deprecated hay không
        if (Calculator.class.getMethod("sum", int.class, int.class).isAnnotationPresent(DeprecatedAPI.class)) {
            System.out.println("Warning: This method is deprecated.");
            DeprecatedAPI annotation = Calculator.class.getMethod("sum", int.class, int.class).getAnnotation(DeprecatedAPI.class);
            System.out.println("Deprecated in version: " + annotation.version());
            System.out.println("Reason: " + annotation.reason());
        }
    }
}