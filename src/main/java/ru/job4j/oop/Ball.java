package ru.job4j.oop;

public class Ball {
    public void eat(String name) {
        if (name.equals("лиса")) {
            System.out.println("А лиса его и съела");
        } else {
            System.out.println("Я от " + name + " ушел");
        }
    }
}
