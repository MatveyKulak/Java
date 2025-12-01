package Laba7.transport;
import java.util.Scanner;

public class Train extends Transport{
    private int numberOfCars;
    private static final double maxDistance = 3000;
    private static final double waitTime = 0.5;

    public Train() {
        super();
    }

    public double calculateTravelTime(double distance) {
        return (distance / getSpeed()) + (distance / 200) * waitTime;
    }

    public String getRecommendation(double distance, int passengers) {
        double time = calculateTravelTime(distance);
        if (distance > maxDistance) {
            return "Поезд '" + getName() + "' не рекомендуется для поездок длиннее " + maxDistance +
                    " км (запрошено " + distance + " км).";
        }
        if (passengers > getCapacity()) {
            return "Поезд '" + getName() + "' не может перевезти " + passengers +
                    " пассажиров (максимум " + getCapacity() + ").";
        }
        return "Поезд '" + getName() + "' - комфортный выбор! Время в пути: " + time + " ч";
    }

    public void set(Scanner scanner) {
        super.set(scanner);
        numberOfCars = TransportUtils.getValidIntInput(scanner, "Введите число вагонов: ", 1);
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Train train = (Train) o;
        return numberOfCars == train.numberOfCars;
    }

    public String toString() {
        return "Поезд { " + super.toString() +
                "Количество вагонов = " + numberOfCars +
                " }";
    }
}