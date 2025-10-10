package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    @Test
    void getLastLogTest() {
        //Given
        Logger logger = Logger.getInstance();
        logger.log("getLastLogTest");
        //When
        String lastLog = logger.getLastLog();
        //Then
        assertEquals("getLastLogTest", lastLog);
    }

    @Test
    void testSingletonLogger() {
        Logger logger = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        assertEquals(logger, logger2);
    }
}
