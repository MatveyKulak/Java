package Laba2;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = 0;
        double sum = 0;
        System.out.print("Последовательность целых неотрицательных чисел (0 для завершения): \n");

        while (true) {
            System.out.print("Введите целое неотрицательное число: ");
            int number = scan.nextInt();

            if (number == 0) {
                break;
            }
            count++;
            sum += number;
        }
        scan.close();

        System.out.println("Количество членов последовательности: " + count);

        double middle = sum / count;
        System.out.printf("Среднее значение последовательности: %.2f\n", middle);
    }
}