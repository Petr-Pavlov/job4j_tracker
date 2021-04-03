package ru.job4j.oop;

public class DummyDic {
    String engToRus(String eng){
        String word = "неизвестное слово " + eng;
        return word;
    }

    public static void main(String[] args) {
        DummyDic dummyDic = new DummyDic();
        String phrase = dummyDic.engToRus(" это слово");
        System.out.println(phrase);
    }
}
