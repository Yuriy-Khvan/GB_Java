// Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых 
// действий к минимуму. 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "input.txt";
        File file = new File(path);
        String[] oneLine = new String[2];
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                oneLine[i++] = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] temp1 = oneLine[0].split(" ");
        String[] temp2 = oneLine[1].split(" ");
        int a = Integer.parseInt(temp1[1]);
        int b = Integer.parseInt(temp2[1]);
        
        if (temp1[0].equals("a")) {
            if (pow((double) a, (double) b) == 0) {
                System.out.println("Не определено");
            } else {
                printResultToFile(a, b);
            }
        } else{
            if (pow((double) b, (double) a) == 0) {
                System.out.println("Не определено");
            } else {
                printResultToFile(b, a);
            }
        }
    }
    public static void terminal() { // Если через терминал:
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите a: ");
        double a = iScanner.nextDouble();
        System.out.printf("Введите b: ");
        double b = iScanner.nextDouble();
        if (pow(a, b) == 0) {
            System.out.println("Не определено");
        } else {
            double c = pow(a, b);
            if (c % 1 != 0) {
                System.out.print(c);
            } else {
                int res = (int) c;
                System.out.print(res);
            }
        }
        iScanner.close();
    }

    public static double pow(double value, double powValue) {
        double result = 1;
        if (powValue == 0) {
            return result;
        } else if (powValue < 0) {
            powValue = powValue * -1;
            for (int i = 1; i <= powValue; i++) {
                result = result * value;
            }
            return result = 1 / result;
        } else if (value == 0) {
            return result = 0;
        } else {
            for (int i = 1; i <= powValue; i++) {
                result = result * value;
            }
            return result;
        }
    }

    public static void printResultToFile(int value, int powValue) {
        double c = pow((double) value, (double)powValue);
        if (c % 1 != 0) {
            writeToFile(c);
        } else {
            int res = (int) c;
            writeToFile(res);
        }
    }

    public static void writeToFile(Object result) {
        try (FileWriter fw = new FileWriter("output.txt", false)){
            fw.write (String.valueOf(result));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }        
    }
}