package Laba6;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Puppy puppy = Puppy.set(scanner);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Показать имя щенка");
            System.out.println("2. Подать голос");
            System.out.println("3. Прыгать");
            System.out.println("4. Бегать");
            System.out.println("5. Кусать");
            System.out.println("6. Покормить");
            System.out.println("7. Изменить собаку");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Имя щенка: " + puppy.getName());
                    break;
                case 2:
                    puppy.sound();
                    break;
                case 3:
                    puppy.jump();
                    break;
                case 4:
                    puppy.run();
                    break;
                case 5:
                    puppy.bite();
                    break;
                case 6:
                    System.out.print("Сколько еды дать (на сколько восстановить энергию)? ");
                    int foodEnergy = scanner.nextInt();
                    puppy.eat(foodEnergy);
                    break;
                case 7:
                    puppy.changeDog(scanner);
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Повторите ввод.");
            }
        }
    }
}