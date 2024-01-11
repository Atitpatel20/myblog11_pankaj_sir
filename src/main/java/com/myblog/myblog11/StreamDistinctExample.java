package com.myblog.myblog11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDistinctExample {
    public static void main(String[] args) {
//        List<String> names = Arrays.asList("apple", "banana", "orange", "apple", "grape", "banana");
//        List<String> distinct = names.stream().distinct().collect(Collectors.toList());
//        List<String> distinctSorted = names.stream().sorted().distinct().collect(Collectors.toList());
//        System.out.println(distinct);
//        System.out.println(distinctSorted);

        List<Person> duplicatePeople = Arrays.asList(
                new Person("Alice", 25, "Female"),
                new Person("Bob", 32, "Male"),
                new Person("Alice", 25, "Female"),
                new Person("Charlie", 28, "Male"),
                new Person("Diana", 22, "Female")
        );
        List<String> collect = duplicatePeople.stream().distinct().map(str -> str.getName()).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(duplicatePeople);
    }
}
