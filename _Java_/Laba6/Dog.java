package Laba6;

import java.util.Scanner;

public class Dog {
    private Animal animal;
    private int energy;
    private Breed breed;

    public enum Breed {
        LABRADOR, BEAGLE, BULLDOG, PUG, CORGI;
    }

    public Dog(Animal animal, Breed breed) {
        this.animal = animal;
        this.breed = breed;
        this.energy = 100;
    }

    public String getName() {
        return animal.getName();
    }

    public void sound() {
        if (energy >= 10) {
            System.out.println(animal.getName() + " : Гав!");
            energy -= 10;
        } else {
            System.out.println(animal.getName() + " слишком устал, чтобы лаять.");
        }
        displayEnergy();
    }

    public void jump() {
        if (energy >= 20) {
            System.out.println(animal.getName() + " прыгает!");
            energy -= 20;
        } else {
            System.out.println(animal.getName() + " слишком устал, чтобы прыгать.");
        }
        displayEnergy();
    }

    public void run() {
        if (energy >= 30) {
            System.out.println(animal.getName() + " бегает!");
            energy -= 30;
        } else {
            System.out.println(animal.getName() + " слишком устал, чтобы бегать.");
        }
        displayEnergy();
    }

    public void bite() {
        if (energy >= 15) {
            System.out.println(animal.getName() + " кусает!");
            energy -= 15;
        } else {
            System.out.println(animal.getName() + " слишком устал, чтобы кусать.");
        }
        displayEnergy();
    }

    public void eat(int foodEnergy) {
        energy = Math.min(100, energy + foodEnergy);
        System.out.println(animal.getName() + " поел. Текущий уровень энергии: " + energy + "%");
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public void inputBreed(Scanner scanner) {
        Breed breed;
        while (true) {
            System.out.println("Выберите породу щенка (введите цифру):");
            System.out.println("1 - LABRADOR");
            System.out.println("2 - BEAGLE");
            System.out.println("3 - BULLDOG");
            System.out.println("4 - PUG");
            System.out.println("5 - CORGI");
            System.out.print("Ваш выбор: ");

            int value = scanner.nextInt();
            if (value == 1) {
                breed = Breed.LABRADOR;
                break;
            } else if (value == 2) {
                breed = Breed.BEAGLE;
                break;
            } else if (value == 3) {
                breed = Breed.BULLDOG;
                break;
            } else if (value == 4) {
                breed = Breed.PUG;
                break;
            } else if (value == 5) {
                breed = Breed.CORGI;
                break;
            } else {
                System.out.println("Введено неправильное значение, повторите ввод.");
            }
        }
        setBreed(breed);
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    private void displayEnergy() {
        System.out.println("Осталось энергии: " + energy + "%");
    }
}