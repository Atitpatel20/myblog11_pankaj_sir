package com.myblog.myblog11;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestClass1 {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(10, 20, 1, 15, 30, 47, 50);
//       Predicate<Integer> val=y-> y%2==0;
//        boolean result = val.test(10);
//        System.out.println(result);

//        Predicate<String> val= str->str.equals("mike");
//        boolean result = val.test("stallin");
//
//        List<Integer> numbers = Arrays.asList(10, 20, 1, 25, 30, 47, 40);
//        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
//        System.out.println(evenNumbers);

//        List<Integer> numbers = Arrays.asList(10, 11, 25, 20, 36, 41, 20);
//        List<Integer> oddNumbers = numbers.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
//        System.out.println(oddNumbers);

//        List<String> numbers = Arrays.asList("mike", "adam", "mike", "stallin");
//        List<String> data1 = numbers.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());
//        List<String> data2 = numbers.stream().filter(s -> s.equals("mike")).collect(Collectors.toList());
//        List<String> data3 = numbers.stream().filter(s -> s.endsWith("n")).collect(Collectors.toList());
//        System.out.println(data1);
//        System.out.println(data2);
//        System.out.println(data3);

        // find the length of given string
        //String Filtering with Length Condition:

        //Scenario: Given a list of strings, filter out the strings that have a length greater than 5.
//        List<String> fruits = Arrays.asList("apple", "banana", "grape", "kiwi", "orange");
//        List<String> result = fruits.stream().filter(frt -> frt.length() > 5).collect(Collectors.toList());
//        System.out.println(result); // [banana, orange]

        //Number Filtering with Range Condition:
       // Scenario: Filter a list of integers to include only those between 20 and 50.

//        List<Integer> numbers = Arrays.asList(10, 20, 25, 30, 35, 45, 50, 60, 70);
//        List<Integer> result = numbers.stream().filter(s -> s >= 20 && s <= 50).collect(Collectors.toList());
//        System.out.println(result); //[20, 25, 30, 35, 45, 50]


        // Combine two conditions to filter out strings starting with "A" and having a length greater than 3.
//        List<String> names = Arrays.asList("Apple", "Banana", "Grape", "Apricot", "Kiwi");
//       List<String>result= names.stream().filter(str-> str.startsWith("A") ||  str.length() > 3).collect(Collectors.toList());
//
//        System.out.println(result);



        // Given a list of strings, filter out strings containing less than three characters and
        // concatenate " - Processed" to each remaining string.
        List<String> listData = Arrays.asList("apple", "cat", "kiwi", "dog", "orange");
        List<String> data1 = listData.stream().filter(str -> str.length() <=3).map(str -> str + " -Processed").collect(Collectors.toList());
        System.out.println(data1);
    }

}
