package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        // Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("sesame")
                .burgers(2)
                .sauce("barbecue")
                .ingredient("bacon")
                .ingredient("cheese")
                .ingredient("lettuce")
                .build();

        System.out.println(bigmac);

        // When
        int burgersCount = bigmac.getBurgers();
        int ingredientsCount = bigmac.getIngredients().size();

        // Then
        assertEquals(2, burgersCount);
        assertEquals(3, ingredientsCount);
        assertEquals("barbecue", bigmac.getSauce());
        assertEquals("sesame", bigmac.getBun());
    }
}
