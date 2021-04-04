package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();

        Book[] collection = new Book[]{book1, book2, book3, book4};
        book1.setName("Clean Code");
        Library.printAll(collection);

        Book temp = collection[0];
        collection[0] = collection[3];
        collection[3] = temp;
        Library.printAll(collection);

        for(Book book : collection) {
            if (book.getName() != null && book.getName().equals("Clean Code")) {
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
