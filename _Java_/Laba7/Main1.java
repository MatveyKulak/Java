package Laba7;

import Laba7.transport.*;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Transport[] transports = new Transport[5];

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Показать все транспортные средства");
            System.out.println("2. Количество созданных транспортных средств");
            System.out.println("3. Ввод данных о новом транспорте");
            System.out.println("4. Изменить данные о транспорте");
            System.out.println("5. Проверить функционал (расчет времени в пути)");
            System.out.println("6. Сравнить два транспортных средства");
            System.out.println("7. Выход");
            System.out.print("Выберите пункт меню: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        TransportUtils.showAll(transports);
                        break;
                    case 2:
                        System.out.println("Количество созданных объектов: " + Transport.getCount());
                        break;
                    case 3:
                        Transport newTransport;
                        System.out.println("Выберите тип транспорта для добавления:");
                        System.out.println("1. Самолет");
                        System.out.println("2. Поезд");
                        System.out.println("3. Автомобиль");
                        System.out.print("Ваш выбор (1-3): ");

                        if (scanner.hasNextInt()) {
                            int type = scanner.nextInt();
                            scanner.nextLine();
                            switch (type) {
                                case 1:
                                    newTransport = new Airplane();
                                    break;
                                case 2:
                                    newTransport = new Train();
                                    break;
                                case 3:
                                    newTransport = new Car();
                                    break;
                                default:
                                    System.out.println("Неверный выбор.");
                                    continue;
                            }
                            newTransport.set(scanner);
                            addTransport(transports, newTransport);
                        }
                        break;
                    case 4:
                        TransportUtils.modifyTransport(transports, scanner);
                        break;
                    case 5:
                        TransportUtils.checkTravelTime(transports, scanner);
                        break;
                    case 6:
                        TransportUtils.compareTransports(transports, scanner);
                        break;
                    case 7:
                        System.out.println("Завершение программы...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Неверный выбор. Попробуйте снова.");
                }
            } else {
                System.out.println("Ошибка: введите число от 1 до 7");
                scanner.next();
            }
        }
    }

    private static void addTransport(Transport[] transports, Transport newTransport) {
        for (int i = 0; i < transports.length; i++) {
            if (transports[i] == null) {
                transports[i] = newTransport;
                System.out.println("Транспорт успешно добавлен!");
                return;
            }
        }
        System.out.println("Нет свободного места для добавления нового транспорта.");
    }
}