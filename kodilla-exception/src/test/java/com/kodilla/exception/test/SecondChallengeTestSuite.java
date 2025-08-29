package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    void probablyIWillThrowExceptionTest() {
        // given
        SecondChallenge secondChallenge = new SecondChallenge();
        // when & then
        assertAll(
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.9, 1.4)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.0, 1.4)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.9, 1.4)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.0, 1.4)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.0, 1.5)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.0, 1.6))
        );
    }
}
