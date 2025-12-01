package Laba10.car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarFile {
    public static final String FileName = "cars.dat";

    private static boolean fileExists() {
        return new File(FileName).exists();
    }

    public static void createInitialFile() {
        List<Car> initialCars = new ArrayList<>();
        initialCars.add(new Car("Toyota Camry", "Toyota", 2020, "Бензин", 50000, 2500000));
        initialCars.add(new Car("Lada Vesta", "АвтоВАЗ", 2021, "Бензин", 100, 1200000));
        initialCars.add(new Car("Hyundai Solaris", "Hyundai", 2019, "Бензин", 80000, 1000000));
        initialCars.add(new Car("Kia Rio", "Kia", 2022, "Бензин", 50, 1500000));
        initialCars.add(new Car("Volkswagen Polo", "Volkswagen", 2020, "Бензин", 70000, 1300000));
        initialCars.add(new Car("Skoda Rapid", "Skoda", 2021, "Бензин", 30000, 1400000));
        initialCars.add(new Car("Renault Logan", "Renault", 2018, "Бензин", 120000, 800000));
        initialCars.add(new Car("Nissan Almera", "Nissan", 2022, "Бензин", 30, 1800000));
        initialCars.add(new Car("BMW X5", "BMW", 2021, "Дизель", 40000, 5000000));
        initialCars.add(new Car("Audi A6", "Audi", 2020, "Бензин", 60000, 4500000));
        initialCars.add(new Car("Mercedes E-class", "Mercedes", 2022, "Дизель", 20, 6000000));
        initialCars.add(new Car("Lexus RX", "Lexus", 2021, "Гибрид", 35000, 5500000));
        initialCars.add(new Car("Mazda CX-5", "Mazda", 2019, "Бензин", 90000, 2000000));
        initialCars.add(new Car("Ford Focus", "Ford", 2020, "Бензин", 75000, 1100000));
        initialCars.add(new Car("Chevrolet Cruze", "Chevrolet", 2017, "Бензин", 150000, 700000));

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(FileName)))) {
            for (Car car : initialCars) {
                oos.writeObject(car);
            }
            System.out.println("Файл успешно создан и заполнен 15 автомобилями.");
        } catch (IOException e) {
            System.err.println("Ошибка при создании файла: " + e.getMessage());
        }
    }

    public static void showAllCars() {
        if (!fileExists()) {
            System.out.println("Файл с автомобилями не существует. Сначала создайте файл.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(FileName)))) {
            System.out.println("Список всех автомобилей:");
            while (true) {
                try {
                    Car car = (Car) ois.readObject();
                    System.out.println(car);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static void addCar(Car car) {
        try {
            ObjectOutputStream oos;
            if (fileExists()) {
                oos = new AppendingObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(FileName, true)));
            } else {
                oos = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(FileName)));
            }

            try (oos) {
                oos.writeObject(car);
                System.out.println("Автомобиль успешно добавлен в файл.");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при добавлении автомобиля: " + e.getMessage());
        }
    }

    public static void showFilteredCars() {
        if (!fileExists()) {
            System.out.println("Файл с автомобилями не существует. Сначала создайте файл.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(FileName)))) {
            System.out.println("Автомобили с пробегом < 100 км и ценой < 200000 руб:");
            boolean found = false;

            while (true) {
                try {
                    Car car = (Car) ois.readObject();
                    if (car.getMileage() < 100 && car.getPrice() < 200000) {
                        System.out.println(car);
                        found = true;
                    }
                } catch (EOFException e) {
                    break;
                }
            }

            if (!found) {
                System.out.println("Нет автомобилей, удовлетворяющих условиям.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    private static class AppendingObjectOutputStream extends ObjectOutputStream {
        public AppendingObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            reset();
        }
    }
}