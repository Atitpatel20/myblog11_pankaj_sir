package com.myblog.myblog11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPredictExample {

    public static void main(String[] args) {

    //Q-1 Given a list of strings, filter out strings with a length less than 5.

        List<String> fruits = Arrays.asList("apple", "banana", "grape", "kiwi", "orange");
        List<String> result1 = fruits.stream().filter(str -> str.length() < 5).collect(Collectors.toList());
        System.out.println(result1);

        // Q-2Given a list of integers, filter out the even numbers.
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = integers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers);

        // Q-3Given a list of Person objects, filter out persons older than 30.
        List<Person> person = Arrays.asList(
                new Person("Alice", 25, "Female"),
                new Person("Bob", 32, "Male"),
                new Person("Charlie", 28, "Male"),
                new Person("Diana", 22, "Female"
                ));
        List<Person> result3 = person.stream().filter(str -> str.getAge() > 30).collect(Collectors.toList());
        System.out.println(result3);

        // Q-4 Given a list of strings, filter out strings starting with the letter 'a'.
                    List<String>  names= Arrays.asList("apple", "banana", "grape", "kiwi", "orange");
        List<String> result4 = names.stream().filter(str -> str.startsWith("a")).collect(Collectors.toList());
        System.out.println(result4);

//     Q-5   Given a list of Person objects, filter out females.
         List <Person> personList=Arrays.asList(
        new Person("Alice", 25, "Female"),
        new Person("Bob", 32, "Male"),
        new Person("Charlie", 28, "Male"),
        new Person("Diana", 22, "Female")
);
        List<Person> result5 = personList.stream().filter(str -> str.getGender().equals("Male")).collect(Collectors.toList());
        System.out.println(result5);

    }
}
