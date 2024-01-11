package com.myblog.myblog11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSortingExample {
    public static void main(String[] args) {

       // sort the elements numbers of a stream in ascending order first & then descending order
//        List<Integer> data1 = Arrays.asList(5, 2, 8, 1, 6, 3, 7, 4);
//        List<Integer> sortedNumbers = data1.stream().sorted().collect(Collectors.toList());
//        System.out.println("Sorted Numbers:"+sortedNumbers);

        // reversed number
//        List<Integer> reverseSorted = data1.stream().sorted((s1, s2) -> Integer.compare(s2, s1)).collect(Collectors.toList());
//        System.out.println("ReverseSorted Numbers: "+reverseSorted);

        // sort the elements numbers of a stream in ascending order first & then descending order

        // ascending order
//        List<String> data2 = Arrays.asList("Apple", "Orange", "Banana", "Grapes");
//        List<String> sortedFruits = data2.stream().sorted().collect(Collectors.toList());
//        System.out.println("Sorted Fruits: "+sortedFruits);

        //  descending order
//        List<String> reverseSortedFruits = data2.stream()
//                .sorted((s1, s2) -> s2.compareTo(s1))
//                .collect(Collectors.toList());
//        System.out.println("Reverse SortedFruits: "+reverseSortedFruits);

        // sort by first age ascending order
        // sort by second age descending order
        // sort by third name ascending order

        List<Person> data = Arrays.asList(
                new Person("Alice", 25, "Female"),
                new Person("Bob", 32, "Male"),
                new Person("Charlie", 28, "Male"),
                new Person("Diana", 22, "Female")
        );

        List<Person> sortedByAgeAsc = data.stream().sorted((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge())).collect(Collectors.toList());
        List<Person> sortedByAgeDesc = data.stream().sorted((s1, s2) -> Integer.compare(s2.getAge(), s1.getAge())).collect(Collectors.toList());
        List<Person> sortedByNameAsc = data.stream().sorted((s1, s2) -> s1.getName().compareTo(s2.getName())).collect(Collectors.toList());

        System.out.println(sortedByAgeAsc);
        System.out.println(sortedByAgeDesc);
        System.out.println(sortedByNameAsc);

    }
}
