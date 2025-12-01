package Laba3;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов первого массива: ");
        int length1 = scanner.nextInt();
        int[] array1 = new int[length1];
        System.out.println("Введите элементы первого массива в порядке возрастания:");
        for (int i = 0; i < length1; i++) {
            array1[i] = scanner.nextInt();
        }

        System.out.print("Введите количество элементов второго массива: ");
        int length2 = scanner.nextInt();
        int[] array2 = new int[length2];
        System.out.println("Введите элементы второго массива в порядке возрастания:");
        for (int j = 0; j < length2; j++) {
            array2[j] = scanner.nextInt();
        }

        System.out.print("Первый массив: ");
//        System.out.print("{ ");
//        for (int n = 0; n < array1.length; n++) {
//            System.out.print(array1[n] + " ");
//        }
//        System.out.print("}\n");
        System.out.println(Arrays.toString(array1));

        System.out.print("Второй массив: ");
        System.out.print("{ ");
        for (int n = 0; n < array2.length; n++) {
            System.out.print(array2[n] + " ");
        }
        System.out.print("}\n");

        int[] array3 = new int[length1 + length2];

        int i = length1 - 1;
        int j = length2 - 1;
        int k = length1 + length2 - 1;

        while (i >= 0 && j >= 0) {
            if (array1[i] > array2[j]) {
                array3[k--] = array1[i--];
            } else {
                array3[k--] = array2[j--];
            }
        }

        while (i >= 0) {
            array3[k--] = array1[i--];
        }

        while (j >= 0) {
            array3[k--] = array2[j--];
        }

        System.out.print("Единый упорядоченный по возрастанию массив: ");
        System.out.print("{ ");
        for (int n = 0; n < array3.length; n++) {
            System.out.print(array3[n] + " ");
        }
        System.out.print("}");
    }
}