package ru.job4j.Inheritance;

public class JSONReport extends TextReport {
    @Override
    public String generate(String name, String body) {
        return String.format("{" + System.lineSeparator()
                + "name: %s," + System.lineSeparator()
                + "body: %s"  + System.lineSeparator()
                + "}", name, body);
    }
}
