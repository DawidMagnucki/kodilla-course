package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        // Given
        Country poland = new Country("Poland", new BigDecimal("38000000"));
        Country germany = new Country("Germany", new BigDecimal("83000000"));
        Country france = new Country("France", new BigDecimal("67000000"));

        Country china = new Country("China", new BigDecimal("1400000000"));
        Country india = new Country("India", new BigDecimal("1380000000"));

        Country nigeria = new Country("Nigeria", new BigDecimal("200000000"));
        Country egypt = new Country("Egypt", new BigDecimal("100000000"));

        Continent europe = new Continent("Europe");
        europe.addCountry(poland);
        europe.addCountry(germany);
        europe.addCountry(france);

        Continent asia = new Continent("Asia");
        asia.addCountry(china);
        asia.addCountry(india);

        Continent africa = new Continent("Africa");
        africa.addCountry(nigeria);
        africa.addCountry(egypt);

        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);

        // When
        BigDecimal totalPeople = world.getPeopleQuantity();

        // Then
        BigDecimal expectedPeople = new BigDecimal("3268000000");
        assertEquals(expectedPeople, totalPeople);
    }
}