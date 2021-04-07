package ru.job4j.poly;

public class Bus implements Transport{
    @Override
    public void go() {
        System.out.println("Поехали");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Пассажиров на борту: " + passengers);
    }

    @Override
    public double refuel(double fuel) {
        return fuel * 45.5;
    }
}
