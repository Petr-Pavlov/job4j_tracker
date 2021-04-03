package ru.job4j.oop;

public class Wolf {
    private String name = "волка";
    public void tryEat(Ball ball) {
        ball.eat(name);
    }
}
