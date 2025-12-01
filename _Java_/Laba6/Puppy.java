package Laba6;
import java.util.Scanner;

class Puppy {
    private Animal animal;
    private Dog dog;

    public Puppy(String name, Dog.Breed breed, int age, double weight) {
        this.animal = new Animal(name, age, weight);
        this.dog = new Dog(animal, breed);
    }

    public static Puppy set(Scanner scanner) {
        Puppy object = new Puppy("", Dog.Breed.LABRADOR, 0, 0.0);

        System.out.println("Определим характеристики щенка.");
        object.animal.inputCharacteristics(scanner);
        object.dog.inputBreed(scanner);

        return object;
    }

    public void changeDog(Scanner scanner) {
        System.out.println("Изменение собаки:");
        animal.inputCharacteristics(scanner);
        dog.inputBreed(scanner);
        dog.setEnergy(100);
    }

    public void sound() {
        dog.sound();
    }

    public String getName() {
        return dog.getName();
    }

    public void jump() {
        dog.jump();
    }

    public void run() {
        dog.run();
    }

    public void bite() {
        dog.bite();
    }

    public void eat(int foodEnergy) {
        dog.eat(foodEnergy);
    }
}