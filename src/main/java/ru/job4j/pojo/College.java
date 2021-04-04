package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Petr");
        student.setSurname("Pavlov");
        student.setPatronymic("Alekseevich");
        student.setGroup("Trainee");
        student.setEnrolled(new Date());
        System.out.println("Student: " + student.getName() + " " + student.getSurname() + " "
        + student.getPatronymic() + " enrolled to study in group: " + student.getGroup() + " by: " + student.getEnrolled());
    }
}
