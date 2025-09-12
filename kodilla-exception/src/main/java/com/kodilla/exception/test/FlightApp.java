package com.kodilla.exception.test;

public class FlightApp {
    public static void main(String[] args) {
        Flight flight1 = new Flight("WAW", "JFK");
        Flight flight2 = new Flight("CDG", "LHR");
        Flight flight3 = new Flight("LHR", "BER");
        Flight flight4 = new Flight("HND", "ABC");

        FlightAvailability flightAvailability = new FlightAvailability();

        try {
            boolean offer1 = flightAvailability.findFlight(flight1);
            System.out.println(offer1);
            boolean offer2 = flightAvailability.findFlight(flight2);
            System.out.println(offer2);
            boolean offer3 = flightAvailability.findFlight(flight3);
            System.out.println(offer3);
            boolean offer4 = flightAvailability.findFlight(flight4);
            System.out.println(offer4);
        } catch (RouteNotFoundException e) {
            System.out.println("Error: "  + e.getMessage());
        }
    }
}
