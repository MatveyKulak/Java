package Laba5;

import java.util.Scanner;

public class DifSquares {
    private double a;
    private double b;

    public DifSquares() {
        this(0, 0);
    }

    public DifSquares(double a, double b) {
        setA(a);
//        this.a = a;
        this.b = b;
    }

    public DifSquares(Scanner scanner) {
        setA(inputAB(scanner, "Введите a: "));
        setB(inputAB(scanner, "Введите b: "));
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {

        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double difOfSquares() {
        return (a * a) - (b * b);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DifSquares that = (DifSquares) o;
        return Double.compare(a, that.a) == 0 && Double.compare(b, that.b) == 0;
    }

    public String numsToString() {
        return String.format("Числа: a = " + getA() + ", b = " + getB());
    }

    public String squaresToString() {
        return String.format("Разность квадратов = " + difOfSquares());
    }

    private static double inputAB(Scanner scanner, String message) {
        double result;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                result = scanner.nextDouble();
                break;
            } else {
                System.out.println("Некорректный ввод. Введите вещественное число.");
                scanner.next();
            }
        }
        return result;
    }
}