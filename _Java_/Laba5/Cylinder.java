package Laba5;

import java.util.Objects;
import java.util.Scanner;

public class Cylinder {
    private double diameter;
    private double height;

    public Cylinder() {
        this(1.0, 1.0);
    }

    public Cylinder(double diameter, double height) {
        this.diameter = diameter;
        this.height = height;
    }

    public Cylinder(Scanner scanner) {
        setDiameter(inputPositive(scanner, "Введите диаметр: "));
        setHeight(inputPositive(scanner, "Введите высоту: "));
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double calculateVolume() {
        double radius = diameter / 2;
        return Math.PI * radius * radius * height;
    }

    public double calculateArea() {
        return Math.PI * diameter * height;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cylinder cylinder = (Cylinder) o;
        return Double.compare(diameter, cylinder.diameter) == 0 && Double.compare(height, cylinder.height) == 0;
    }

    public String toString() {
        return "Цилиндр: диаметр = " + diameter + ", высота = " + height ;
//                ", объем = " + calculateVolume() +
//                ", площадь боковой поверхности = " + calculateArea();
    }

    public String info() {
        return "Цилиндр: диаметр = " + getDiameter() + ", высота = " + getHeight();
    }

    public String calculatInfo() {
        return "Объем = " + calculateVolume() + ", площадь боковой поверхности = " + calculateArea();
    }

    private static double inputPositive(Scanner scanner, String message) {
        double result;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                result = scanner.nextDouble();
                if (result > 0) {
                    break;
                } else {
                    System.out.println("Значение должно быть положительным.");
                }
            } else {
                System.out.println("Некорректный ввод. Введите вещественное число.");
                scanner.next();
            }
        }
        return result;
    }
}