package Laba1;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input x: ");
        double x = scan.nextDouble();
        scan.close();

        double a = 4.5, b = 8.4;
        double z = Math.tan(Math.pow(b * x, 2));
        double result;

        if (x <= a) {
            result = a * Math.pow(Math.cos(x), 2) + b * Math.sin(z * x);
            System.out.printf("Option 1: If x <= a, then answer: %.2f\n", result);
        } else if (x <= 4.5 * b) {
            result = a * Math.tan(a * x + z) + Math.pow(Math.sin(b * x), 2);
            System.out.printf("Option 1: If a < x <= 4.5*b, then answer: %.2f\n", result);
        } else {
            result = Math.log(a * x - b) + Math.pow(z, 2);
            System.out.printf("Option 1: If x >= 4.5*b, then answer: %.2f\n", result);
        }

        a = 8.2;
        b = 15.2;
        z = Math.tan(Math.pow(b * x, 2));

        if (x <= a) {
            result = a * Math.pow(Math.cos(x), 2) + b * Math.sin(z * x);
            System.out.printf("Option 2: If x <= a, then answer: %.2f\n", result);
        } else if (x <= 4.5 * b) {
            result = a * Math.tan(a * x + z) + Math.pow(Math.sin(b * x), 2);
            System.out.printf("Option 2: If a < x <= 4.5*b, then answer: %.2f\n", result);
        } else {
            result = Math.log(a * x - b) + Math.pow(z, 2);
            System.out.printf("Option 2: If x >= 4.5*b, then answer: %.2f\n", result);
        }

        a = 1.7;
        b = 0.5;
        z = Math.tan(b * Math.pow(x, 2));

        if (x <= a) {
            result = a * Math.pow(Math.cos(x), 2) + b * Math.sin(z * x);
            System.out.printf("Option 3: If x <= a, then answer: %.2f\n", result);
        } else if (x <= 4.5 * b) {
            result = a * Math.tan(a * x + z) + Math.pow(Math.sin(b * x), 2);
            System.out.printf("Option 3: If a < x <= 4.5*b, then answer: %.2f\n", result);
        } else {
            result = Math.log(a * x - b) + Math.pow(z, 2);
            System.out.printf("Option 3: If x >= 4.5*b, then answer: %.2f\n", result);
        }
    }
}