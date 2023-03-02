
import java.util.Scanner;

/**
 * Задание 1. Формула треугольного числа n
 */
public class home1 {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // outputResult(work(input(text: "Введите число n: ")));
        int num = work(input("Введите n: "));
        outputResult(num);
    }
    
    public static int input(String text) {
        System.out.print(text);
        return input.nextInt();
    }
    public static int work(int n) {
        int result = n*(n + 1)/2;
        return result;
    }
    
    static void outputResult(int arg) {
        System.out.println(arg);
    }
}