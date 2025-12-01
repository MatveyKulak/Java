package Laba5;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cylinder[] parameters = new Cylinder[4];

        for (int i = 0; i < parameters.length; i++) {
            System.out.println("Введите данные для цилиндра " + (i + 1) + ":");
            parameters[i] = new Cylinder(scanner);
        }

        System.out.println("Содержимое массива цилиндров:");
        for (Cylinder cylinder : parameters) {
            System.out.println(cylinder.info());
            System.out.println(cylinder.calculatInfo());
        }

        for (int i = 0; i < parameters.length; i++) {
            for (int j = i + 1; j < parameters.length; j++) {
              if (parameters[i].equals(parameters[j])) {
                    System.out.println("Цилиндры " + (i + 1) + " и " + (j + 1) + " равны.");
                } else {
                    System.out.println("Цилиндры " + (i + 1) + " и " + (j + 1) + " не равны.");
                }
            }
        }
        scanner.close();
    }
}