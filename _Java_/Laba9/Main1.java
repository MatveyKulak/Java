package Laba9;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lottery method = new Lottery();

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Показать все билеты");
            System.out.println("2. Добавить билет");
            System.out.println("3. Изменить билет");
            System.out.println("4. Удалить билет");
            System.out.println("5. Сортировать по сумме цифр");
            System.out.println("6. Показать билеты с одинаковыми цифрами");
            System.out.println("7. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    method.showTickets();
                    break;
                case 2:
                    System.out.print("Введите номер билета (4 цифры): ");
                    method.addTicket(scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Введите позицию для изменения: ");
                    int index = scanner.nextInt();
                    System.out.print("Введите новый номер: ");
                    method.updateTicket(index, scanner.nextInt());
                    break;
                case 4:
                    System.out.print("Введите позицию для удаления: ");
                    method.removeTicket(scanner.nextInt());
                    break;
                case 5:
                    method.sortBySum();
                    break;
                case 6:
                    method.findSameTickets();
                    method.showSameTickets();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Неверный выбор");
            }
        }
    }
}
