package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {

    @BeforeEach
    void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    void after() {
        System.out.println("Test Case: end");
    }

    @DisplayName("When create empty OddNumbersExterminator " +
            "then exterminate should return empty list"
    )
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> emptyList = List.of();
        //when
        List<Integer> result = oddNumbersExterminator.exterminate(emptyList);
        //then
        Assertions.assertTrue(result.isEmpty());

    }

    @DisplayName("when creating OddNumbersExterminator with random numbers " +
            "then exterminate should return only even numbers")

    @Test
    void testOddNumbersExterminatorNormalList() {
        //given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> normalList = List.of(1, 2, 3, 4, 5);
        //when
        List<Integer> result = oddNumbersExterminator.exterminate(normalList);
        //then
        Assertions.assertEquals(List.of(2, 4), result);
    }

    @DisplayName("using ArraysAsList " +
            "when creating OddNumbersExterminator with random numbers " +
            "then exterminate should return only even numbers")

    @Test
    void testOddNumbersExterminatorArraysAsList() {
        //given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> input = Arrays.asList(75, 86, 84, 5, 7, 9, 6);
        List<Integer> expected = Arrays.asList(86, 84, 6);
        //when
        List<Integer> result = oddNumbersExterminator.exterminate(input);
        //then
        Assertions.assertEquals(expected, result);
    }
}
