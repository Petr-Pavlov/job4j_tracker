package ru.job4j.oop;

public class Hare {
    private String name = "зайца";
    public void tryEat(Ball ball) {
        ball.eat(name);
    }
}
