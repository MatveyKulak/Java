package Laba7.transport;
import java.util.Scanner;

public class Airplane extends Transport{
    private double wingSpan;
    private static final double minDistance = 1000;
    private static final double time = 2.0;

    public Airplane() {
        super();
    }

    public double calculateTravelTime(double distance) {
        return (distance / getSpeed()) + time;
    }

    public String getRecommendation(double distance, int passengers) {
        double time = calculateTravelTime(distance);
        if (distance < minDistance) {
            return "Самолет '" + getName() + "' не рекомендуется для поездок короче " + minDistance +
                    " км (запрошено " + distance + " км).";
        }
        if (passengers > getCapacity()) {
            return "Самолет '" + getName() + "' не может перевезти " + passengers +
                    " пассажиров (максимум " + getCapacity() + ").";
        }
        return "Самолет '" + getName() + "' - отличный выбор! Время полета: " + time + " ч";
    }

    public void set(Scanner scanner) {
        super.set(scanner);
        this.wingSpan = TransportUtils.getValidDoubleInput(scanner, "Введите размах крыльев: ", 0);
    }


    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Airplane airplane = (Airplane) o;
        return Double.compare(wingSpan, airplane.wingSpan) == 0;
    }

    public String toString() {
        return "Самолёт { " + super.toString() +
                "Размах крыльев = " + wingSpan +
                " }";
    }
}