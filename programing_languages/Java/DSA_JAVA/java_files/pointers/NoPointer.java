package DSA_JAVA.java_files.pointers;

public class NoPointer {
    public static void main(String[] args) {
        int num1=11;
        int num2=num1;

        num1=22;
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);
    }
}
