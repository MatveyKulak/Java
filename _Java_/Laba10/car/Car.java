package Laba10.car;

import java.io.Serializable;
import java.util.Scanner;

public class Car implements Serializable {
    private String brand;
    private String manufacturer;
    private int year;
    private String engineType;
    private int mileage;
    private int price;

    public Car(String brand, String manufacturer, int year, String engineType, int mileage, int price) {
        this.brand = brand;
        this.manufacturer = manufacturer;
        this.year = year;
        this.engineType = engineType;
        this.mileage = mileage;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getYear() {
        return year;
    }

    public String getEngineType() {
        return engineType;
    }

    public int getMileage() {
        return mileage;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Автомобиль{" +
                "Марка = '" + brand + '\'' +
                ", Производитель = '" + manufacturer + '\'' +
                ", Год выпуска = " + year +
                ", Тип двигателя = '" + engineType + '\'' +
                ", Пробег(км) = " + mileage +
                ", Цена = " + price +
                '}';
    }

    public static Car addNewCar(Scanner scanner) {
        System.out.println("Добавление нового автомобиля:");

        String brand = getNonEmptyInput(scanner, "Марка автомобиля: ");
        String manufacturer = getNonEmptyInput(scanner, "Производитель: ");
        int year = getIntInput(scanner, "Год выпуска: ");
        String engineType = getNonEmptyInput(scanner, "Тип двигателя: ");
        int mileage = getIntInput(scanner, "Пробег (км): ");
        int price = getIntInput(scanner, "Цена (руб): ");

        return new Car(brand, manufacturer, year, engineType, mileage, price);
    }

    private static String getNonEmptyInput(Scanner scanner, String message) {
        String input;
        do {
            System.out.print(message);
            input = scanner.nextLine();
        } while (input.isEmpty());
        return input;
    }

    private static int getIntInput(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            }
            scanner.nextLine();
        }
    }
}