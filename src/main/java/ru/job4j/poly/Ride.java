package ru.job4j.poly;

public class Ride {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] park = {airplane, train, bus};
        for (Vehicle item : park) {
            item.move();
        }
    }
}
