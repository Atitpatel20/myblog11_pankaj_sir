package com.myblog.myblog11;

import lombok.Data;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public static void main(String[] args) {
//        List<Person> people = Arrays.asList(
//                new Person("Alice", 25, "Female"),
//                new Person("Bob", 32, "Male"),
//                new Person("Charlie", 28, "Male"),
//                new Person("Diana", 22, "Female")
//        );
//
//        List<String> names = people.stream()
//                .filter(person -> person.getGender().equals("Female") && person.getAge() < 30)
//                .map(Person::getName)
//                .collect(Collectors.toList());
//
//        System.out.println(names);

//        List<LocalDate> dates = Arrays.asList(
//                LocalDate.of(2022, 5, 15),
//                LocalDate.of(2023, 2, 28),
//                LocalDate.of(2024, 8, 10),
//                LocalDate.of(2025, 12, 5)
//        );
//        LocalDate referenceDate = LocalDate.of(2024, 1, 1);
//        List<LocalDate> resultDate = dates.stream().filter(date -> date.isAfter(referenceDate)).collect(Collectors.toList());
//        System.out.println(resultDate);

        // Filter and Map to combine examples:

        //  Given a list of numbers, filter out even numbers and
        //  map the remaining numbers to their squares.
//        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        List<Integer> collectNum = integers.stream().filter(i -> i % 2 == 0).map(i -> i * i).collect(Collectors.toList());
//        System.out.println(collectNum);

        // Given a list of Person objects, filter out males and
        // map the remaining persons to their names.
//        List<Person> listName = Arrays.asList(
//                new Person("Alice", 25, "Female"),
//                new Person("Bob", 32, "Male"),
//                new Person("Charlie", 28, "Male"),
//                new Person("Diana", 22, "Female")
//        );
//        List<String> male = listName.stream().filter(str -> str.getGender().equals("Female")).map(str -> str.getName()).collect(Collectors.toList());
//        System.out.println(male);

// Given a list of integers, filter out numbers greater than 50 and
// map the remaining numbers to their square roots.

        List<Integer> integers1 = Arrays.asList(25, 36, 49, 64, 81, 100, 121);
        List<Integer> collectInt = integers1.stream().filter(i -> i > 50).map(i -> i * i).collect(Collectors.toList());
        System.out.println(collectInt);




















    }
}
