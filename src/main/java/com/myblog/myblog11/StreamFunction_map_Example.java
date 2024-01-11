package com.myblog.myblog11;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Data
public class StreamFunction_map_Example {
    public static void main(String[] args) {

        // Scenario: Given a list of numbers, map each number to its square.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result1 = numbers.stream().map(num -> num * num).collect(Collectors.toList());
        System.out.println(result1);

        //  Given a list of strings, map each string to its length.
        List<String> words = Arrays.asList("apple", "banana", "grape", "kiwi", "orange");
        List<Integer> result2 = words.stream().map(str->str.length()).collect(Collectors.toList());
        System.out.println(result2);

       // Given a list of Person objects, map each person to their age.
        List<Person> people = Arrays.asList(
                new Person("Alice", 25, "Female"),
                new Person("Bob", 32, "Male"),
                new Person("Charlie", 28, "Male"),
                new Person("Diana", 22, "Female")
        );
        List<Integer> result3 = people.stream().map(Person::getAge).collect(Collectors.toList());
        System.out.println(result3);

        //Scenario: Given a list of strings, filter out strings that contain the letter 'a'
        // and map the remaining strings to uppercase.
        List<String> names = Arrays.asList("apple", "banana", "grape", "kiwi", "orange");
        List<String> result4 = names.stream().filter(str -> str.startsWith("a")).map(str -> str.toUpperCase()).collect(Collectors.toList());
        System.out.println(result4);

        // Given a list of numbers, map each number to a string by concatenating it with a prefix.
        List<Integer> newNumbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> result5 = newNumbers.stream().map(num -> "Number: " + num).collect(Collectors.toList());
        System.out.println(result5);
    }
}
