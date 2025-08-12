package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {
        double sum = 0.0;
        int count = 0;

        for (Double temperature : temperatures.getTemperatures().values()) {
            sum += temperature;
            count++;
        }
        if (count == 0) {
            return 0.0;
        }
        return sum / count;
    }

    public double calculateMedianTemperature() {
        List<Double> temps = new ArrayList<>(this.temperatures.getTemperatures().values());
        if (temps.isEmpty()) {
            return 0.0;
        }
        Collections.sort(temps);
        int count = temps.size();
        if (count % 2 == 0) {
            return (temps.get(count / 2 - 1) + temps.get(count / 2)) / 2.0;
        } else {
            return temps.get(count / 2);
        }
    }
}
