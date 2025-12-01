package Laba7.transport;
import java.util.Objects;
import java.util.Scanner;

public abstract class Transport {
    private String name;
    private double speed;
    private double capacity;
    private static int count = 0;

    public Transport() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void set(Scanner scanner) {
        System.out.print("Введите название: ");
        this.name = scanner.nextLine();
        this.speed = TransportUtils.getValidDoubleInput(scanner, "Введите скорость: ", 0);
        this.capacity = TransportUtils.getValidDoubleInput(scanner, "Введите вместимость: ", 1);
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Double.compare(speed, transport.speed) == 0 && Double.compare(capacity, transport.capacity) == 0 && Objects.equals(name, transport.name);
    }

    public String toString() {
        return "Транспорт { Название = '" + getName() + "', скорость = " + getSpeed() + ", вместимость = " + getCapacity() + " }";
    }

    public abstract double calculateTravelTime(double distance);
    public abstract String getRecommendation(double distance, int passengers);
}