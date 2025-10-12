package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User millenial = new Millenials("Millenial");
        User yGeneration = new YGeneration("YGeneration");
        User zGeneration = new ZGeneration("ZGeneration");

        //When
        String millenialPost = millenial.sharePost();
        String yGenerationPost = yGeneration.sharePost();
        String zGenerationPost = zGeneration.sharePost();

        //Then
        assertEquals("Post on Facebook", millenialPost);
        assertEquals("Post on Twitter", yGenerationPost);
        assertEquals("Post on Snapchat", zGenerationPost);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User zGeneration = new ZGeneration("ZGeneration");

        //When
        zGeneration.setSocialPublisher(new FacebookPublisher());
        String newPost = zGeneration.sharePost();

        //Then
        assertEquals("Post on Facebook", newPost);
    }
}
