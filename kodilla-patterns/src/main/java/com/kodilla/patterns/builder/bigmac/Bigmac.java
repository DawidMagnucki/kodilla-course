package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private final String bun;
    private final int burgers;
    private final String sauce;
    private final List<String> ingredients;

    private Bigmac(String bun, int burgers, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    public static class BigmacBuilder {

        private String bun;
        private int burgers;
        private String sauce;
        private final List<String> ingredients = new ArrayList<>();

        private static final List<String> VALID_BUNS = List.of("sesame", "plain");
        private static final List<String> VALID_SAUCES = List.of("standard", "1000 islands", "barbecue");
        private static final List<String> VALID_INGREDIENTS = List.of(
                "lettuce", "onion", "bacon", "cucumber", "chilli peppers", "mushrooms", "shrimps", "cheese"
        );

        public BigmacBuilder bun(String bun) {
            if (!VALID_BUNS.contains(bun)) {
                throw new IllegalArgumentException("Invalid bun: " + bun);
            }
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            if (burgers < 1 || burgers > 3) {
                throw new IllegalArgumentException("Number of burgers must be between 1 and 3");
            }
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            if (!VALID_SAUCES.contains(sauce)) {
                throw new IllegalArgumentException("Invalid sauce: " + sauce);
            }
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            if (!VALID_INGREDIENTS.contains(ingredient)) {
                throw new IllegalArgumentException("Invalid ingredient: " + ingredient);
            }
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            if (bun == null || sauce == null) {
                throw new IllegalStateException("Bun and sauce must be chosen!");
            }
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }
}
