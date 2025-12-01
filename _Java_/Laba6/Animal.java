package Laba6;

import java.util.Scanner;

public class Animal {
    private String name;
    private int age;
    private double weight;

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void inputCharacteristics(Scanner scanner) {
        inputName(scanner);
        inputAge(scanner);
        inputWeight(scanner);
    }

    private void inputName(Scanner scanner) {
        while (true) {
            System.out.print("Введите имя: ");
            String name = scanner.next();
            if (name != null && !name.isEmpty()) {
                setName(name);
                break;
            } else {
                System.out.println("Имя не может быть пустым. Введите корректное имя:");
            }
        }
    }

    private void inputAge(Scanner scanner) {
        while (true) {
            System.out.print("Введите возраст (в месяцах): ");
            int age = scanner.nextInt();
            if (age >= 0) {
                setAge(age);
                break;
            } else {
                System.out.println("Возраст не может быть отрицательным. Введите корректный возраст (в месяцах):");
            }
        }
    }

    private void inputWeight(Scanner scanner) {
        while (true) {
            System.out.print("Введите вес (в килограммах): ");
            double weight = scanner.nextDouble();
            if (weight > 0) {
                setWeight(weight);
                break;
            } else {
                System.out.println("Вес не может быть отрицательным или равным нулю. Введите корректный вес (в килограммах):");
            }
        }
    }
}