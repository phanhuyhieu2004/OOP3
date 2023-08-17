package bai7;

public class JavaReflectionTest{
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> newClass=Class.forName("JavaReflection");
        String className=newClass.getName();
        System.out.println("Tên của lớp là  :"+ className);

    }
}
