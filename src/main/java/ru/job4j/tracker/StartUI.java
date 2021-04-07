package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] items = tracker.findAll();
                for (Item temp : items) {
                    System.out.println(temp);
                }
            } else if (select == 2) {
                System.out.print("Enter item`s id: ");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.print("Enter item`s name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Item is successfully edited");
                } else {
                    System.out.println("Error");
                }
            } else if (select == 3) {
                System.out.println("Enter item`s id: ");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Item is successfully edited");
                } else {
                    System.out.println("Error");
                }
            } else if (select == 4) {
                System.out.println("Enter item`s id: ");
                int id = Integer.valueOf(scanner.nextLine());
                Item temp = tracker.findById(id);
                if (temp == null) {
                    System.out.println("Item with id: " + id + " is not found");
                } else {
                    System.out.println(temp);
                }
            } else if (select == 5) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item[] temp = tracker.findByName(name);
                if (temp.length > 0) {
                    for (Item current : temp) {
                        System.out.println(current);
                    }
                } else {
                    System.out.println("Items with name: " + name + " are not found");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu. \n"
                + "0. Add new Item\n"
                + "1. Show all items\n"
                + "2. Edit item\n"
                + "3. Delete item\n"
                + "4. Find item by Id\n"
                + "5. Find items by name\n"
                + "6. Exit Program\n"
                + "Select:");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
