package org.review.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayTest {
    @Test
    @DisplayName("Create an array")
    void createArray() {
        Integer [] numbers = new Integer[5];
        assertEquals(5, numbers.length);
    }
    @Test
    @DisplayName("Adding and Accessing array data")
    void addingDataToAnArrayAndAccessingArrayData() {
        Integer [] numbers = new Integer[5];
        numbers[0] = 1;
        numbers[1] = 2;
        assertEquals(1, numbers[0]);
        assertEquals(2, numbers[1]);
    }
    @Test
    @DisplayName("Update and Accessing array data")
    void updateDataToAnArrayAndAccessingArrayData() {
        Integer [] numbers = new Integer[5];
        numbers[0] = 1;
        numbers[0] = 2;
        assertEquals(2, numbers[0]);

    }
    @Test
    @DisplayName("Adding and Accesing array data")
    void accesingArrayData() {
        Integer [] numbers = {1,3,5,7,8,9};
        // Form 1
        System.out.println("Form 1");
        for (int i = 0; i < numbers.length ; i++) {

            System.out.printf("Number[%s] = %s %n",i,numbers[i] );
        }
        System.out.println("Form 2");

        for (int j: numbers){
            System.out.printf("Number = %s %n",j );
        }
        System.out.println("Form 3");
        Arrays.stream(numbers).toList().forEach(j ->  System.out.printf("Numbe= %s %n",j ));
        assertEquals(6, numbers.length);

    }
}
