package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        System.out.println("Факториал числа 5 равен: " + calc(5));
    }

    public static int calc(int n) {
        int rsl = 1;
        if (n < 0) {
            throw new IllegalArgumentException("number should be more than zero");
        }
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
