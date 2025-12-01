package Laba7.transport;
import java.util.Scanner;

public class TransportUtils {
    public static void showAll(Transport[] transports) {
        System.out.println("Все транспортные средства:");
        for (int i = 0; i < transports.length; i++) {
            if (transports[i] != null) {
                System.out.println((i + 1) + ". " + transports[i]);
            }
        }
    }

    public static void compareTransports(Transport[] transports, Scanner scanner) {
        Transport first = selectTransport(transports, scanner, "первое");
        Transport second = selectTransport(transports, scanner, "второе");

        if (first != null && second != null) {
            System.out.println("Сравнение:");
            System.out.println("1. " + first);
            System.out.println("2. " + second);
            System.out.println(first.equals(second) ?
                    "Эти транспортные средства равны по характеристикам" :
                    "Эти транспортные средства не равны по характеристикам");
        }
    }

    private static Transport selectTransport(Transport[] transports, Scanner scanner, String order) {
        showAll(transports);
        System.out.print("Выберите " + order + " транспортное средство (1-" + transports.length + "): ");

        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt() - 1;
                scanner.nextLine();

                if (choice >= 0 && choice < transports.length && transports[choice] != null) {
                    return transports[choice];
                }
            } else {
                scanner.nextLine();
            }
            System.out.print("Неверный ввод. Пожалуйста, введите номер от 1 до " + transports.length + ": ");
        }
    }

    public static void modifyTransport(Transport[] transports, Scanner scanner) {
        showAll(transports);
        Transport transport = selectTransport(transports, scanner, "для изменения");

        System.out.println("Текущие данные:");
        System.out.println(transport);

        transport.set(scanner);

        System.out.println("Данные успешно обновлены!");
    }

    public static void checkTravelTime(Transport[] transports, Scanner scanner) {
        double distance = getValidDoubleInput(scanner, "Введите расстояние для расчета (км): ", 0);
        int passengers = getValidIntInput(scanner, "Введите количество пассажиров: ", 1);

        System.out.println("Рекомендации:");
        for (Transport transport : transports) {
            if (transport != null) {
                System.out.println("- " + transport.getRecommendation(distance, passengers));
            }
        }
    }

    public static double getValidDoubleInput(Scanner scanner, String text, double min) {
        while (true) {
            System.out.print(text);
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine();
                if (value >= min) {
                    return value;
                }
            } else {
                scanner.nextLine();
            }
            System.out.println("Ошибка! Введите число от " + min);
        }
    }

    public static int getValidIntInput(Scanner scanner, String text, int min) {
        while (true) {
            System.out.print(text);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                if (value >= min) {
                    return value;
                }
            } else {
                scanner.nextLine();
            }
            System.out.println("Ошибка! Введите целое число от " + min);
        }
    }
}