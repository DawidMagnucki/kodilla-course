package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;

import org.junit.jupiter.api.*;

class ForumTestSuite {
    @BeforeEach
    void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName("when create SimpleUser with realName, " +
            "then getRealName should return real user name"
    )
    @Test
    void testCaseRealName() {
        //given
        SimpleUser simpleUser = new SimpleUser("The Forum User", "John Smith");
        //when
        String result = simpleUser.getRealName();
        System.out.println("Testing " + result);
        //then
        Assertions.assertEquals("John Smith", result);
    }

    @DisplayName("when create SimpleUser with name, " +
            "then getUsername should return correct name"
    )

    @Test
    void testCaseUsername() {
        //given
        SimpleUser simpleUser = new SimpleUser("The Forum User", "John Smith");

        String expectedResult = "The Forum User";

        //when
        String result = simpleUser.getUsername();
        //then
        Assertions.assertEquals(expectedResult, result);
    }
}