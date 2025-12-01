package Laba7.transport;
import java.util.Objects;
import java.util.Scanner;

public class Car extends Transport {
    private String fuelType;
    private static final double maxDistance = 500;
    private static final double refuelTime = 0.5;

    public Car() {
        super();
    }

    public double calculateTravelTime(double distance) {
        return (distance / getSpeed()) + (distance / 300) * refuelTime;
    }

    public String getRecommendation(double distance, int passengers) {
        double time = calculateTravelTime(distance);
        if (distance > maxDistance) {
            return "Автомобиль '" + getName() + "' не рекомендуется для поездок длиннее " + maxDistance +
                    " км (запрошено " + distance + " км).";
        }
        if (passengers > getCapacity()) {
            return "Автомобиль '" + getName() + "' не может перевезти " + passengers +
                    " пассажиров (максимум " + getCapacity() + ").";
        }
        return "Автомобиль '" + getName() + "' - удобный выбор! Время в пути: " + time + " ч";
    }

    public void set(Scanner scanner) {
        super.set(scanner);
        System.out.print("Введите тип топлива: ");
        this.fuelType = scanner.nextLine();
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return Objects.equals(fuelType, car.fuelType);
    }

    public String toString() {
        return "Машина { " + super.toString() +
                "Тип топлива = '" + fuelType +
                " }";
    }
}