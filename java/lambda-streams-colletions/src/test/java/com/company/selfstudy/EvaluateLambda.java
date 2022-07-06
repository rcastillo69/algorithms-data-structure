package com.company.selfstudy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

class EvaluateLambda {
    @Test
    @DisplayName("Evaluate use of lamda")
    void testLambda1(){
        List<Integer> items = Arrays.asList(1,2,3,4,5,6);

        // Classic way
        for(int i : items){
            System.out.printf("Classic %n");
            System.out.printf("Number :%s%n", i);
        }

        // Iterate for lambda
        items.forEach(i -> {
            System.out.printf("Lambda way %n");
            System.out.println(String.format("Number :%s", i));
        });

        // Iterate by Reference
        items.forEach(System.out::println);

    }
    @Test
    @DisplayName("Comparator")
    void comparatorString() {
        String[] words = {"Hi","Adios","Hola","Aloha","Bye"};
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));

        // Order by length shortest

        Arrays.sort(words, (s1,s2)-> Integer.compare(s1.length(), s2.length()));
        System.out.println(Arrays.toString(words));

        // Order by length shortest

        Arrays.sort(words, (s1,s2)-> -1*Integer.compare(s1.length(), s2.length()));
        System.out.println(Arrays.toString(words));
    }

    @Test
    @DisplayName("Print and Sort Collections")
    void printCollections() {
        Set<String> superCycleSet = new TreeSet<>();
        List<String> myStoreList = new ArrayList<>();

        myStoreList.add("Bicycle");
        myStoreList.add("Tricycle");
        myStoreList.add("Scooter");
        myStoreList.add("Scooter");
        myStoreList.add("Scooter");

        myStoreList.forEach(i -> System.out.printf("My store item: %s%n", i));

        myStoreList.forEach( i-> {
            if(!superCycleSet.contains(i)){
                superCycleSet.add(i);
            }
        });

        superCycleSet.forEach(i -> System.out.println("Super Cycle item: " + i));

    }

}
