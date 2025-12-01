package Laba4;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер (n) квадратной матрицы nxn: ");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        System.out.println("Введите целочисленные элементы матрицы(ввод по столбикам):");
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                System.out.printf("Элемент [%d][%d]: ", i + 1, j + 1);
                matrix[i][j] = scanner.nextInt();
            }
        }
        int min = findMin(matrix);
        System.out.printf("Столбец с минимальным количеством элементов, кратных сумме индексов элемента: %d", min);
    }

    public static int findMin(int[][] matrix) {
        int n = matrix.length;
        int minimum = n;
        int stolbik = 0;

        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                int sum = (i + 1) + (j + 1);
                if (matrix[i][j] % sum == 0) {
                    count++;
                }
            }
            if (count < minimum) {
                minimum = count;
                stolbik = j;
            }
        }
        return stolbik + 1;
    }
}