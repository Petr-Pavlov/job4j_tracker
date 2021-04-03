package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public void printInfo() {
        System.out.println("Активность: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public Error() {}

    public Error (boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(false, 1, "ошибка номер 1");
        Error error3 = new Error(true, 2, "ошибка номер 2");
        error1.printInfo();
        error2.printInfo();
        error3.printInfo();
    }
}
