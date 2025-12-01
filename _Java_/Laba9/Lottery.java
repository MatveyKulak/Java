package Laba9;
import java.util.*;

public class Lottery {
    private List<Integer> tickets = new ArrayList<>(Arrays.asList(
            1111, 2222, 3333, 4444, 5555,
            6666, 7777, 8888, 9999, 1000,
            1234, 2345, 3456, 4567, 6789
    ));
    private Queue<Integer> queue = new LinkedList<>();

    public void showTickets() {
        System.out.println("Список билетов:");
        int counter = 1;
        for (Integer ticket : tickets) {
            System.out.println(counter++ + ". " + ticket);
        }
    }

    public void addTicket(int number) {
        if (number >= 1000 && number <= 9999) {
            tickets.add(number);
            System.out.println("Билет добавлен");
        } else {
            System.out.println("Неверный номер билета");
        }
    }

    public void updateTicket(int index, int newNumber) {
        if (index >= 1 && index <= tickets.size() && newNumber >= 1000 && newNumber <= 9999) {
            tickets.set(index-1, newNumber);
            System.out.println("Билет изменен");
        } else {
            System.out.println("Неверные данные");
        }
    }

    public void removeTicket(int index) {
        if (index >= 1 && index <= tickets.size()) {
            tickets.remove(index-1);
            System.out.println("Билет удален");
        } else {
            System.out.println("Неверный индекс");
        }
    }

    public void sortBySum() {
        tickets.sort((a, b) -> Integer.compare(calculateDigitSum(a), calculateDigitSum(b)));
        System.out.println("Билеты отсортированы по сумме цифр");
        showTickets();
    }

    public void findSameTickets() {
        for (int ticket : tickets) {
            if (allSame(ticket)) {
                queue.add(ticket);
            }
        }
    }

    public void showSameTickets() {
        if (queue.isEmpty()) {
            System.out.println("Нет билетов с одинаковыми цифрами");
            return;
        }
        System.out.println("Билеты с одинаковыми цифрами:");
        Queue<Integer> tempQueue = new LinkedList<>(queue);
        while (!tempQueue.isEmpty()) {
            System.out.println(tempQueue.poll());
        }
    }

    private int calculateDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private boolean allSame(int number) {
        int last = number % 10;
        while (number > 0) {
            if (number % 10 != last) {
                return false;
            }
            number /= 10;
        }
        return true;
    }
}
