package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean Code",500);
        Book book2 = new Book("Essentials", 350);
        Book book3 = new Book("Work Book", 754);
        Book book4 = new Book("Clean Code 2", 681);

        Book[] collection = new Book[]{book1, book2, book3, book4};
        Library.printAll(collection);

        Book temp = collection[0];
        collection[0] = collection[3];
        collection[3] = temp;
        Library.printAll(collection);

        for(Book book : collection) {
            if ("Clean Code".equals(book.getName())) {
                System.out.println(book);
            }
        }
    }

    public static void printAll(Book[] collection) {
        for (int i = 0; i < collection.length; i++) {
            System.out.println(collection[i]);
        }

    }
}
