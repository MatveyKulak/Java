package Laba10;
import java.util.Scanner;
import java.io.File;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню управления автомобилями");
            System.out.println("1. Создать файл с начальными данными");
            System.out.println("2. Показать все автомобили");
            System.out.println("3. Добавить автомобиль");
            System.out.println("4. Показать автомобили с пробегом < 100 км и ценой < 200000 руб");
            System.out.println("5. Выход");
            System.out.print("Выберите пункт меню: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Laba10.car.CarFile.createInitialFile();
                    break;
                case 2:
                    Laba10.car.CarFile.showAllCars();
                    break;
                case 3:
                    Laba10.car.Car newCar = Laba10.car.Car.addNewCar(scanner);
                    Laba10.car.CarFile.addCar(newCar);
                    break;
                case 4:
                    Laba10.car.CarFile.showFilteredCars();
                    break;
                case 5:
                    System.out.println("Выход из программы...");
                    new File(Laba10.car.CarFile.FileName).delete();
                    return;
            }
        }
    }
}