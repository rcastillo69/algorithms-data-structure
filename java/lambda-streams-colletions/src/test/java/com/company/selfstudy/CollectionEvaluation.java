package com.company.selfstudy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionEvaluation {


    @Test
    @DisplayName("List")
    void evaluateList() {
        List<Integer> items1 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> items2 = new LinkedList<>();
        items2.add(1);
        items2.add(2);
        items2.add(3);
        items2.add(4);

        // Iterate items 1
        items1.forEach(i-> System.out.printf("List1 item: %s%n",i));

        // Iterate items 2
        items2.forEach(i-> System.out.printf("List2 item: %s%n",i));


    }
    @Test
    @DisplayName("List")
    void evaluateSet() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(10006);
        set1.add(23);
        set1.add(333);
        set1.add(1);
        Set<Integer> set2 = new TreeSet<>(Arrays.asList(15, 26, 7, 18, 9));
        // Iterate items 1
        set1.forEach(i-> System.out.printf("Set1 item: %s%n",i));

        // Iterate items 2
        set2.forEach(i-> System.out.printf("Set2 item: %s%n",i));


    }

    @Test
    @DisplayName("List")
    void evaluateQueueDeque() {
        Queue<Integer> q1 = new PriorityQueue<>();
        q1.add(10006);
        q1.add(23);
        q1.add(333);
        q1.add(1);
        Deque<Integer> d1 = new LinkedList<>(Arrays.asList(15, 26, 7, 18, 9));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(115, 216, 17, 118, 19));
        // Iterate items 1
        q1.forEach(i-> System.out.printf("q1 item: %s%n",i));

        // Iterate items 2
        d1.forEach(i-> System.out.printf("d1 item: %s%n",i));
        d2.forEach(i-> System.out.printf("d2 item: %s%n",i));


    }

    @Test
    @DisplayName("List")
    void evaluateMao() {
       // Map<String,Integer> m1 = Map.of("A",1,"B",2, "C", 3);
       /* Map<String,Integer> m2 = new TreeMap<>();
        m1.put("A",1);
        m1.put("B",2);
        m1.put("C",3);
*/


    }

    @Test
    @DisplayName("List")
    void operationList() {
        List<Integer> items1 = new ArrayList<>();
        Boolean ok = items1.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        // Add 19
        items1.add(19);
        Assertions.assertTrue(items1.contains(19));

        // Search 19
        Integer value = items1.get(items1.indexOf(19));
        Assertions.assertEquals(19, value);

        // Set position
        items1.set(1,19);
        value = items1.get(1);
        Assertions.assertEquals(19, value);

        // replace number 1 by 0
        items1.forEach(i-> System.out.println(i));
        System.out.println("***");
        Integer position = items1.get(items1.indexOf(5));
        items1.set(position,0);
        items1.forEach(i-> System.out.println(i));
        Assertions.assertEquals(5, items1.get(4));

    }

    @Test
    @DisplayName("Map operations")
    void operationMap() {
        Map<Integer,String> map1 = new HashMap<>();

        // Add items
        map1.put(1,"A");
        map1.put(2,"B");
        map1.put(3,"C");
        map1.put(4,"D");

        Assertions.assertTrue(map1.containsKey(1));
        Assertions.assertTrue(map1.containsValue("A"));

        // Search item 3 o C
        Assertions.assertTrue(map1.containsKey(3));
        Assertions.assertTrue(map1.containsValue("C"));

        // Replace item
        map1.forEach((k,v)-> System.out.println((k + ":" + v)));
        System.out.println("***");
        map1.put(4,"DD");
        map1.forEach((k,v)-> System.out.println((k + ":" + v)));

        Assertions.assertEquals("DD", map1.getOrDefault(4,""));
        // Not found
        String letter = map1.getOrDefault(5,"");
        Assertions.assertEquals("", letter);

        // Remove item

        map1.remove(4);
        System.out.println("***");
        map1.forEach((k,v)-> System.out.println((k + ":" + v)));


    }

    @Test
    @DisplayName("Map operations")
    void operationStream() {

        List<Integer> items1 = Arrays.asList(1,2,3,4,5,6,7,8,9);
       // Filter
       List<Integer> odd = items1.stream()
               .filter(i -> i % 2 != 0)
               .sorted((i1,i2) ->(-1)*Integer.compare(i1,i2))
               .toList();

        odd.forEach(System.out::println);

       Predicate<Integer> IsOdd = i -> i % 2 != 0;
       Comparator<Integer> orderDec = (i1,i2) ->(-1)*Integer.compare(i1,i2);

        odd = items1.stream()
                .filter(IsOdd)
                .sorted(orderDec)
                .toList();
        System.out.printf("Order way two %n");
        odd.forEach(i-> System.out.println(i));
        //Sum items
        Integer total = odd.stream().reduce(0,Integer::sum);
        System.out.printf("Sum of odd = %s%n",total);

        total = odd.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.printf("Sum of odd = %s%n",total);

        //Max item
        Integer max = odd.stream().reduce(0,Integer::max);
        System.out.printf("Max of odd = %s%n",max);

        //Min item
        Integer min = odd.stream().reduce(1,Integer::min);
        System.out.printf("Min of odd = %s%n",min);

        //Min item
        Double average = odd.stream().collect(Collectors.averagingInt(Integer::intValue));
        System.out.printf("Average of odd = %s%n",average);

        total = odd.stream()
                .mapToInt(Integer::intValue)
                        .sum();
        System.out.printf("Average of odd = %s%n",average);

    }
}
