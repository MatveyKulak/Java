package Laba5;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DifSquares[] objects = new DifSquares[4];

        for (int i = 0; i < objects.length; i++) {
            System.out.println("Введите значения для массива " + (i + 1) + ":");
            objects[i] = new DifSquares(scanner);
        }

        for (int i = 0; i < objects.length; i++) {
            for (int j = i + 1; j < objects.length; j++) {
                if (objects[i].equals(objects[j])) {
                    System.out.println("Значения a у объектов " + (i+1) + " и " + (j+1) + " равны.");
                } else {
                    System.out.println("Значения b у объектов " + (i+1) + " и " + (j+1) + " не равны.");
                }
            }
        }

        System.out.println("Содержимое массива + Ответ:");
        for (DifSquares object : objects) {
            System.out.println(object.numsToString());
            System.out.println(object.squaresToString());
        }
        scanner.close();
    }
}