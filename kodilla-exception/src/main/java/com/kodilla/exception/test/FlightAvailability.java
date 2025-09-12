package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightAvailability {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String,Boolean> airports = new HashMap<>();
        airports.put("BER",false);
        airports.put("WAW",true);
        airports.put("LHR",true);
        airports.put("JFK",true);
        airports.put("HND",true);
        airports.put("CDG",true);

        String arrival = flight.getArrivalAirport();

        if(!airports.containsKey(arrival)){
            throw new RouteNotFoundException("Arrival airport " + arrival + " does not operate.");
        }
        return airports.get(arrival);
    }
}
